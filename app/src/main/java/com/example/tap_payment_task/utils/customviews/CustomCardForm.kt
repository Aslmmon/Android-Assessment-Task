package com.example.tap_payment_task.utils.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tap_payment_task.R
import com.example.tap_payment_task.utils.handleEnteringExpiryFieldsAutomatically

/**
 * CustomView for CardForm
 * to be reusable when needed
 *
 */
class CustomCardForm @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {
    private val TAG = CustomCardForm::class.simpleName


    init {
        val rootView =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.custom_card_form,
                this,
                true
            )
        val cardExpiryEditText = rootView.findViewById<EditText>(R.id.ed_expiry)

        /**
         *
         * Extension function on EditText to be able to enter MM/YY automatically
         * without need to handle it from UI
         *
         */
        cardExpiryEditText.handleEnteringExpiryFieldsAutomatically()
    }
}