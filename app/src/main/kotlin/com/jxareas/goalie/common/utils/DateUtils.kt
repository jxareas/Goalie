package com.jxareas.goalie.common.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    fun formatDateTime(value: String?): String =
        if (value.isNullOrBlank()) {
            "Unknown Date"
        } else {
            val dateParser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault()).apply {
                timeZone = TimeZone.getTimeZone("UTC")
            }
            val date = dateParser.parse(value)
            val dateFormatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

            dateFormatter.format(date!!)
        }
}
