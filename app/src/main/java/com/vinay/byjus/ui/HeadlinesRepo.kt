package com.vinay.byjus.ui

import com.vinay.byjus.db.HeadlineDao
import com.vinay.byjus.ui.home.HeadlinesDataSource
import com.vinay.byjus.response.headlines.Article
import com.vinay.byjus.network.FetchService
import com.vinay.byjus.network.RequestStatus
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
@Singleton
class HeadlinesRepo @Inject constructor(
        private val fetchService: FetchService,
        private val dao: HeadlineDao
): HeadlinesDataSource {

    override suspend fun getHeadlines(): RequestStatus<List<Article>> {
        var result: RequestStatus<List<Article>>? = null
        runCatching {
            val response = fetchService.getHeadlines()
            dao.insertHeadlines(response.articles)

            val responseFromDb = dao.getAllHeadlines()
            val list = mutableListOf<Article>()

            list.addAll(responseFromDb)
            result = RequestStatus.Success(list)
        }.onFailure {
            val responseFromDb = dao.getAllHeadlines()
            result = if (responseFromDb.isNotEmpty()) {
                RequestStatus.Success(responseFromDb)
            } else {
                RequestStatus.Error(it)
            }
        }
        return result!!
    }
}