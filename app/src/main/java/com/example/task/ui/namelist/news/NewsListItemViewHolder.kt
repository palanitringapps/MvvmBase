package com.example.task.ui.namelist.news

import androidx.recyclerview.widget.RecyclerView
import com.example.task.databinding.AdapterNewsListBinding


class NewsListItemViewHolder(val bind: AdapterNewsListBinding) :
    RecyclerView.ViewHolder(bind.root) {
    fun onBind(viewModel: NewsItemViewModel) {
        bind.tvSmbName.text = viewModel.newsPayload.title
        bind.tvSmbAddress.text = viewModel.newsPayload.description
        bind.ciSmbProfile.setImageURI(viewModel.imagePath())
        bind.executePendingBindings()
    }

    fun unBind() {
        bind.unbind()
    }
}