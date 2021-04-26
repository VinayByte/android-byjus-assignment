package com.vinay.byjus.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vinay.byjus.response.headlines.Article

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
@Dao
interface HeadlineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeadlines(list: List<Article>)

    @Query("SELECT * FROM Article")
    suspend fun getAllHeadlines(): List<Article>
}