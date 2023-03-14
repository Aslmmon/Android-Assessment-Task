package com.example.tap_payment_task.features.main_screen_user_input.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.tap_payment_task.R
import com.example.tap_payment_task.databinding.FragmentMainBinding
import com.example.tap_payment_task.features.SharedViewModel
import com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation.TapPaymentBottomSheet
import com.example.tap_payment_task.utils.convertToDecimalPlaces
import com.example.tap_payment_task.utils.morphAndRevert


class MainUserInputFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private var mainUserInputViewModel = MainUserInputViewModel()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(_binding) {
            this?.btnPay?.setOnClickListener {
                if (isAmountEnterdNotEmpty() == true) {
                    btnPay.morphAndRevert(onAnimationEnd = {
                        sharedViewModel.setPaymentAmount(
                            getAmountPaymentTyped(),
                            getCurrency(getAmountPaymentTyped())
                        )
                        openTapPaymentBottomSheet()
                        clearAmountEditText()

                    })
                }

            }
            this?.edAmountText?.doOnTextChanged { text, start, before, count ->
                mainUserInputViewModel.setAmountWritten(
                    text.toString().convertToDecimalPlaces() ?: ""
                )
            }


            mainUserInputViewModel.amountTyped.observe(requireActivity(), Observer { textTyped ->
                this?.btnPay?.text =
                    resources.getString(R.string.pay, textTyped, getCurrency(textTyped))
            })
        }

    }

    private fun getAmountPaymentTyped() = _binding?.edAmountText?.text.toString()

    private fun clearAmountEditText() = _binding?.edAmountText?.text?.clear()
    private fun isAmountEnterdNotEmpty() = _binding?.edAmountText?.text?.isNotEmpty()


    private fun getCurrency(textTyped: String): String {
        var currency = resources.getString(R.string.currency)
        if (textTyped.isEmpty()) currency = ""
        return currency
    }

    private fun openTapPaymentBottomSheet() {
        val tapPaymentBottomSheet = TapPaymentBottomSheet()
        tapPaymentBottomSheet.apply {
            show(this@MainUserInputFragment.childFragmentManager, tapPaymentBottomSheet.tag)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}




