package com.vinay.byjus.response.headlines


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
@Parcelize
data class Source(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String
) : Parcelable