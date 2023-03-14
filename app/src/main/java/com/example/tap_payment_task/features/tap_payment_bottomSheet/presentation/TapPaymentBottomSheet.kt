package com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.tap_payment_task.R
import com.example.tap_payment_task.databinding.TapPaymentBottomSheetContentBinding
import com.example.tap_payment_task.features.SharedViewModel
import com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation.adapter.PaymentTypeData
import com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation.adapter.PaymentsTypesAdapter
import com.example.tap_payment_task.utils.convertToDecimalPlaces
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TapPaymentBottomSheet : BottomSheetDialogFragment() {

    lateinit var paymentsTypesAdapter: PaymentsTypesAdapter
    lateinit var binding: TapPaymentBottomSheetContentBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()


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
        initializeAndSubmitAdapterList()
        sharedViewModel.paymentAmount.observe(requireActivity(), Observer {
            bindDataToViews(it)
        })

        with(binding) {
            ivCloseDialog.setOnClickListener {
                this@TapPaymentBottomSheet.dismiss()
            }
            rvPaymentsType.adapter = paymentsTypesAdapter

            edExpiry.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    if (s?.length == 2) {
                        if(start==2 && before==1 && !s.toString().contains("/")){
                            edExpiry.setText(""+ s.toString()[0]);
                            edExpiry.setSelection(1);
                        }
                        else {
                            edExpiry.setText("$s/");
                            edExpiry.setSelection(3);
                        }
                    }
                }
            })
        }

    }

    private fun bindDataToViews(amountWithCurrency: Pair<String, String>) {
        /**
         * amountWithCurrency first Pair ->> total Amount
         * amountWithCurrency Second Pair ->> Currency
         */
        binding.tvAmount.text = activity?.getString(
            R.string.amount_text,
            amountWithCurrency.second,
            amountWithCurrency.first.convertToDecimalPlaces()
        )
        binding.btnPayTapPayment.text = activity?.getString(
            R.string.pay,
            amountWithCurrency.second,
            amountWithCurrency.first.convertToDecimalPlaces()
        )


    }

    private fun initializeAndSubmitAdapterList() {
        paymentsTypesAdapter = PaymentsTypesAdapter()
        paymentsTypesAdapter.submitList(initPaymentTypeList())

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