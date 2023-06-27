package com.example.newsapi.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapi.data.model.New
import com.example.newsapi.databinding.NewsViewHolderBinding

class NewAdapter(private var news: List<New>, private val onNewClick: OnNewClick) :
    RecyclerView.Adapter<NewAdapter.NewViewHolder>() {
    inner class NewViewHolder(private val binding: NewsViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(new: New) {
            Glide.with(binding.root.context)
                .load(new.urlToImage)
                .into(binding.imageNew)

            binding.textTitle.text = new.title
            binding.textAuthor.text = new.author
            binding.textPublished.text = new.publishedAt

            binding.root.setOnClickListener {
                onNewClick.onClick(new)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsViewHolderBinding.inflate(inflater, parent, false)
        return NewViewHolder(binding)
    }

    fun updateNews(newNews: List<New?>) {
        news = newNews.filterNotNull()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        holder.bind(news[position])
    }

    override fun getItemCount(): Int = news.size

    interface OnNewClick {
        fun onClick(new: New)
    }
}