package com.example.calculatorlove.ui.history.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calculatorlove.databinding.ItemHistoryBinding
import com.example.calculatorlove.model.LoveModel

class AdapterHistory(private val onClick: (LoveModel) -> Unit, private val onLongClick: (LoveModel) -> Unit) :
    RecyclerView.Adapter<AdapterHistory.ViewHolderHistory>() {

    private var list = arrayListOf<LoveModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun getAllList(lists: List<LoveModel>) {
        list.clear()
        list.addAll(lists)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHistory {
        return ViewHolderHistory(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderHistory, position: Int) {
        holder.onBind(list[position])
    }

    inner class ViewHolderHistory(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(loveModel: LoveModel) {
            binding.tvMe.text = loveModel.firstName
            binding.tvYou.text = loveModel.secondName
            binding.tvPercentage.text = loveModel.percentage
            itemView.setOnLongClickListener {
                onLongClick(loveModel)
                false
            }
            itemView.setOnClickListener {
                onClick(loveModel)
            }
        }

    }
}