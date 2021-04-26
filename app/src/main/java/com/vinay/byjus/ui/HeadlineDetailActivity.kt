package com.vinay.byjus.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.vinay.byjus.R
import com.vinay.byjus.utils.Utils
import com.vinay.byjus.response.headlines.Article
import kotlinx.android.synthetic.main.activity_headline_detail.*
/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
class HeadlineDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headline_detail)

        val article: Article? = intent.getParcelableExtra(ARTICLE_ITEM)
        if (article == null) {
            // this should never happen
            Log.e("HeadlinesDetail", "article null from intent")
            return
        }

        populateUI(article)
    }

    private fun populateUI(article: Article) {
        articleHeadline.text = article.title
        sourceTextView.text = article.source.name
        articleDescription.text = article.description
        Glide.with(this).load(article.urlToImage)
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(R.drawable.glide_placeholder)
            .error(R.drawable.glide_placeholder)
            .into(headlinesImage)
        backArrowBg.setOnClickListener { onBackPressed() }
        articleDate.text = Utils.getFormattedDate(article.publishedAt)
    }

    companion object {
        private const val ARTICLE_ITEM = "article item"
        fun newInstance(context: Context, article: Article) =
            Intent(context, HeadlineDetailActivity::class.java).apply {
                putExtra(ARTICLE_ITEM, article)
            }
    }
}
