package com.example.calculatorlove.ui.onbord.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.calculatorlove.R
import com.example.calculatorlove.databinding.ItemOnBoardBinding
import com.example.calculatorlove.model.OnBord


class AdapterOnBoard(val onClick: () -> Unit) : RecyclerView.Adapter<AdapterOnBoard.ViewHolderOnBord>() {

    private val list = arrayListOf(
        OnBord(
            "Have a good time",
            "You should take the time to help those who need you",
            R.raw.love
        ),
        OnBord(
            "Cherishing love",
            "It is now no longer possible for you to cherish love",
            R.raw.love_and_kind
        ),
        OnBord(
            "Have a break up?",
            "We have made the correction for you don't worry. Maybe someone is waiting for you",
            R.raw.heart_love_animation
        ),
        OnBord(
            "It's Funs and Many more", "",
            R.raw.book_lover
        )
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOnBord {
        return ViewHolderOnBord(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolderOnBord, position: Int) {
        holder.onBind(list[position])
    }

    inner class ViewHolderOnBord(private val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(onBoard: OnBord) {
            binding.tvTitle.text = onBoard.title
            binding.tvDesc.text = onBoard.desc
            binding.btnNext.setOnClickListener {
                onClick()
            }
            binding.btnNext.isVisible = adapterPosition == list.lastIndex
        }
    }
}