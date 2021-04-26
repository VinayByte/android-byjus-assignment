package com.vinay.byjus.network

import com.vinay.byjus.constants.Constants
import com.vinay.byjus.response.headlines.HeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
interface FetchService {
    @GET(Constants.GET_HEADLINES)
    suspend fun getHeadlines(@Query("country") country: String = "us"): HeadlinesResponse
}