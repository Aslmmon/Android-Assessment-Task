package com.example.tap_payment_task.features.tap_payment_bottomSheet.data.model

import android.net.Uri

/**
 * here we have 2 cases
 * if  isHaveCardData ->> true  view will be of image + card data
 * if isHaveCardData ->> false view will show only other options to pay with
 */
data class PaymentSourcesResponse(
    var id: Int? = null,
    var image: Uri? = null,
    var isHaveCardData: Boolean = false,
    var cardNumber: String? = null
)