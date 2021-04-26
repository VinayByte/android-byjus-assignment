package com.vinay.byjus.utils

import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
object Utils {
    fun getFormattedDate(dateString: String): String {
        val date = LocalDate.parse(dateString, DateTimeFormatter.ISO_ZONED_DATE_TIME)
        return date.toString()
    }
}