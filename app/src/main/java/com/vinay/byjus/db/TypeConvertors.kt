package com.vinay.byjus.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vinay.byjus.response.headlines.Source

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
class TypeConvertors {

    val gson = Gson()

    @TypeConverter
    fun sourceToString(source: Source): String {
        return gson.toJson(source)
    }

    @TypeConverter
    fun stringToSource(string: String): Source {
        val type = object : TypeToken<Source>() {}.type
        return gson.fromJson<Source>(string, type)
    }
}