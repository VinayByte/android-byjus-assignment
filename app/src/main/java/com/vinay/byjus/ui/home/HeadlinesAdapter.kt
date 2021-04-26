package com.vinay.byjus.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.vinay.byjus.R
import com.vinay.byjus.utils.Utils
import com.vinay.byjus.response.headlines.Article

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
class HeadlinesAdapter(private val list: List<Article>, private val onClick: (Article) -> Unit) :
    RecyclerView.Adapter<HeadlinesAdapter.HeadlinesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlinesViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.headlines_item_view, parent, false)
        return HeadlinesViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HeadlinesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class HeadlinesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val source: TextView = itemView.findViewById(R.id.sourceTextView)
        private val headline: TextView = itemView.findViewById(R.id.headlineTextView)
        private val backgroundImage: ImageView = itemView.findViewById(R.id.articleBackgroundImage)
        private val date: TextView = itemView.findViewById(R.id.articleDate)
        fun bind(article: Article) {
            source.text = article.source.name
            headline.text = article.title
            date.text = Utils.getFormattedDate(article.publishedAt)
            Glide.with(itemView)
                .load(article.urlToImage)
                .transition(DrawableTransitionOptions.withCrossFade())
                .placeholder(R.drawable.glide_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(backgroundImage)

            itemView.setOnClickListener { onClick.invoke(article) }
        }
    }
}