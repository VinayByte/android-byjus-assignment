package com.vinay.byjus.network

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
sealed class RequestStatus<out T : Any> {
    data class Success<out T : Any>(val data: T) : RequestStatus<T>()
    data class Error(val exception: Throwable) : RequestStatus<Nothing>()
}