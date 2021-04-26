package com.vinay.byjus.ui.home

import com.vinay.byjus.response.headlines.Article
import com.vinay.byjus.network.RequestStatus

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
interface HeadlinesDataSource {
    suspend fun getHeadlines(): RequestStatus<List<Article>>
}