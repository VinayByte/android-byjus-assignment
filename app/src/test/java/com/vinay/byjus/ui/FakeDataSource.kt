package com.vinay.byjus.ui

import com.vinay.byjus.network.RequestStatus
import com.vinay.byjus.response.headlines.Article
import com.vinay.byjus.response.headlines.Source
import com.vinay.byjus.ui.home.HeadlinesDataSource

class FakeDataSource() : HeadlinesDataSource {
    override suspend fun getHeadlines(): RequestStatus<List<Article>> {

        return RequestStatus.Success(listOf(Article("", "", "", "", Source(",", ""), "", "")))
    }
}