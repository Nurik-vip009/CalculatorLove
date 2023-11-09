package com.example.calculatorlove.ui.onbord

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.calculatorlove.R
import com.example.calculatorlove.databinding.FragmentOnBoardBinding
import com.example.calculatorlove.ui.onbord.adapter.AdapterOnBoard
import com.example.calculatorlove.ui.onbord.viewmodel.OnBordViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OnBoardFragment  : Fragment(R.layout.fragment_on_board) {

    private val binding: FragmentOnBoardBinding by viewBinding(FragmentOnBoardBinding::bind)
    private lateinit var adapterOnBoard: AdapterOnBoard
    private val viewModel: OnBordViewModel by viewModels ()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterOnBoard = AdapterOnBoard(this::onClick)
        binding.viewPager.adapter = adapterOnBoard
        if (viewModel.isUserSeen()) {
            findNavController().navigate(R.id.calculatorFragment)
        }
        binding.indicator.setViewPager(binding.viewPager)
    }

    private fun onClick() {
        viewModel.saveUserSeen()
        findNavController().navigate(R.id.calculatorFragment)
    }
}