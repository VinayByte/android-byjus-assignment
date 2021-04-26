package com.vinay.byjus.di

import android.content.Context
import androidx.room.Room
import com.vinay.byjus.db.AppDatabase
import com.vinay.byjus.db.HeadlineDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun providesDatabase(context: Context): AppDatabase {
        val builder = Room.databaseBuilder(context, AppDatabase::class.java, "vinay_db")
        return builder.build()
    }

    @Provides
    @Singleton
    fun providesHeadlinesDao(appDatabase: AppDatabase): HeadlineDao = appDatabase.getHeadlinesDao()
}