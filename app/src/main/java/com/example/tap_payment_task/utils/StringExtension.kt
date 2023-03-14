package com.example.tap_payment_task.utils

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.text.DecimalFormat

/**
 *
 * Extension class functions for Strings
 */
const val threeDecimalPlaces = 3

/**
 * this function to update String to be in 3 Decimal Digits
 * for ex: 1,354,3443
 */
fun String.convertToDecimalPlaces(decimalPlaces: Int = threeDecimalPlaces): String? {
    return try {
        val df = DecimalFormat()
        df.maximumFractionDigits = decimalPlaces
        df.format(this.toDouble())
    } catch (e: Exception) {
        ""
    }

}

