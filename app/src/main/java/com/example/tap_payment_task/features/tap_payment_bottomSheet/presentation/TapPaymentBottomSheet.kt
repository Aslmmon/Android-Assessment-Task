package com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tap_payment_task.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TapPaymentBottomSheet : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_modal, container, false)
    }
}