package com.vinay.byjus.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.vinay.byjus.BuildConfig
import com.vinay.byjus.constants.Constants
import com.vinay.byjus.network.FetchService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun getOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: Interceptor
    ): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
            .addNetworkInterceptor(StethoInterceptor())


        if (BuildConfig.DEBUG)
            httpBuilder.addInterceptor(loggingInterceptor)
        return httpBuilder.build()
    }

    @Provides
    @Singleton
    fun getHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request =
                chain.request().newBuilder()
                    .addHeader("X-Api-Key", Constants.API_KEY)
                    .build()
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    @Provides
    @Singleton
    fun getApiClient(retrofit: Retrofit): FetchService {
        return retrofit.create(FetchService::class.java)
    }
}