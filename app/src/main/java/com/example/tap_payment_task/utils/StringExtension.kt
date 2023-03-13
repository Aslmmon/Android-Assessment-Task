package com.example.tap_payment_task.utils

import java.text.DecimalFormat

const val threeDecimalPlaces = 3

fun String.convertToDecimalPlaces(decimalPlaces: Int = threeDecimalPlaces): String? {
    return try {
        val df = DecimalFormat()
        df.maximumFractionDigits = decimalPlaces
        df.format(this.toDouble())
    } catch (e: Exception) {
        ""
    }


}