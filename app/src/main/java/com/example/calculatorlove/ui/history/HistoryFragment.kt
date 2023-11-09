package com.example.calculatorlove.ui.history

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.calculatorlove.ui.history.adapter.AdapterHistory
import com.example.calculatorlove.ui.history.viewmodel.HistoryViewModel
import com.example.calculatorlove.R
import com.example.calculatorlove.databinding.FragmentHistoryBinding
import com.example.calculatorlove.model.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.fragment_history) {

    private val binding: FragmentHistoryBinding by viewBinding(FragmentHistoryBinding::bind)
    private val viewModel: HistoryViewModel by viewModels()
    private val adapterHistory: AdapterHistory by lazy {
        AdapterHistory(
            this::onClick,
            this::onLongClick
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()

    }

    private fun setData() {
        val list = viewModel.getData()
        adapterHistory.getAllList(list)
        binding.recyclerView.adapter = adapterHistory
    }

    @SuppressLint("ResourceType")
    private fun onClick(loveModel: LoveModel) {
        findNavController().navigate(R.layout.fragment_change, bundleOf(KEY_FOR_UPDATE to loveModel))
        setData()
    }

    private fun onLongClick(loveModel: LoveModel) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete?")
        builder.setMessage("Delete sure")
        builder.setPositiveButton("Delete") { d, _ ->
            viewModel.deleteData(loveModel)
            setData()
            d.dismiss()
        }
        builder.setNegativeButton("No") { d, _ ->
            d.dismiss()
        }
        builder.create().show()
    }
    companion object{
        const val KEY_FOR_UPDATE = "key"
    }
}