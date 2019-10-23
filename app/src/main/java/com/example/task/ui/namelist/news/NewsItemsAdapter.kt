package com.example.task.ui.namelist.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task.data.model.NewsData
import com.example.task.databinding.AdapterNewsListBinding


class NewsItemsAdapter : RecyclerView.Adapter<NewsListItemViewHolder>() {

    private var newsData = mutableListOf<NewsData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListItemViewHolder {
        return NewsListItemViewHolder(
            AdapterNewsListBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun getItemCount(): Int {
        return newsData.size
    }

    override fun onBindViewHolder(holder: NewsListItemViewHolder, position: Int) {
        holder.onBind(NewsItemViewModel(newsData[position]))
    }


    override fun onViewDetachedFromWindow(holder: NewsListItemViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.unBind()
    }


    fun updateData(data: ArrayList<NewsData>?) {
        with(newsData) {
            clear()
            data?.let { addAll(it) }
        }
        notifyDataSetChanged()
    }
}