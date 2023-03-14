package com.example.tap_payment_task.utils

import android.content.Context
import android.widget.Toast


/**
 *
 * Extension functions for Context
 */
fun Context.showToast(toastMessage: String, toastType: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, toastMessage, toastType).show()

}