package com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tap_payment_task.R
import com.example.tap_payment_task.databinding.TapPaymentBottomSheetContentBinding
import com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation.adapter.PaymentTypeData
import com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation.adapter.PaymentsTypesAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TapPaymentBottomSheet : BottomSheetDialogFragment() {

    lateinit var paymentsTypesAdapter: PaymentsTypesAdapter
    lateinit var binding: TapPaymentBottomSheetContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TapPaymentBottomSheetContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPaymentTypeList()
        paymentsTypesAdapter = PaymentsTypesAdapter()
        paymentsTypesAdapter.submitList(initPaymentTypeList())

        binding.rvPaymentsType.adapter = paymentsTypesAdapter

    }

    private fun initPaymentTypeList(): MutableList<PaymentTypeData> {
        return mutableListOf<PaymentTypeData>(
            PaymentTypeData(
                1,
                ContextCompat.getDrawable(requireContext(), R.drawable.apple_pay)
            ),
            PaymentTypeData(
                2,
                ContextCompat.getDrawable(requireContext(), R.drawable.google_pay)
            ),
            PaymentTypeData(
                3,
                ContextCompat.getDrawable(requireContext(), R.drawable.apple_pay)
            ),
            PaymentTypeData(
                4,
                ContextCompat.getDrawable(requireContext(), R.drawable.google_pay)
            )
        )
    }
}