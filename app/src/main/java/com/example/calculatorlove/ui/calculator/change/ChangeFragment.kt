package com.example.calculatorlove.ui.calculator.change

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.calculatorlove.ui.calculator.change.viewmodel.ChangeViewModel
import com.example.calculatorlove.ui.history.HistoryFragment.Companion.KEY_FOR_UPDATE
import com.example.calculatorlove.R
import com.example.calculatorlove.databinding.FragmentChangeBinding
import com.example.calculatorlove.model.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("ResourceType")
@AndroidEntryPoint
class ChangeFragment : Fragment(R.id.changeFragment) {

    private val viewModel: ChangeViewModel by viewModels()
    private val binding: FragmentChangeBinding by viewBinding(FragmentChangeBinding::bind)
    private var loveModel: LoveModel? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loveModel = arguments?.getSerializable(KEY_FOR_UPDATE) as LoveModel?
        loveModel?.let {
            binding.etFirs.setText(it.firstName)
            binding.etSecond.setText(it.secondName)
            binding.etResult.setText(it.result)
            binding.etPercentage.setText(it.percentage)
        }
        binding.btnGet.setOnClickListener {
            if (binding.etFirs.text.toString() == "" && binding.etSecond.text.toString() == "" && binding.etPercentage.text.toString() == "" && binding.etResult.text.toString() == "") {
                Toast.makeText(requireContext(), "The field cannot be empty", Toast.LENGTH_SHORT)
                    .show()
            } else {
                updateData()
            }
        }
    }

    private fun updateData() {

        val result = loveModel?.copy(
            firstName = binding.etFirs.text.toString(),
            secondName = binding.etSecond.text.toString(),
            result = binding.etResult.text.toString(),
            percentage = binding.etPercentage.text.toString() + "%"
        )
        if (result != null) {
            viewModel.updateData(result)
        }
        findNavController().navigateUp()
    }
}