package com.example.calculatorlove.ui.result

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.calculatorlove.R
import com.example.calculatorlove.databinding.FragmentResultBinding
import com.example.calculatorlove.model.LoveModel
import com.example.calculatorlove.ui.calculator.CalculatorFragment.Companion.KEY_FOR_DATA


class ResultFragment : Fragment(R.layout.fragment_result) {

    private var loveModel: LoveModel? = null
    private val binding: FragmentResultBinding by viewBinding(FragmentResultBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loveModel = arguments?.getSerializable(KEY_FOR_DATA) as LoveModel
        loveModel?.let {
            binding.tvMe.text = it.firstName
            binding.tvYou.text = it.secondName
            binding.tvPercentage.text = it.percentage
            binding.tvYourScope.text = it.result
        }
        binding.btnTryAgain.setOnClickListener { findNavController().navigateUp() }
    }
}