package com.example.tap_payment_task.utils.customviews

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tap_payment_task.R

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
        cardExpiryEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s?.length == 2) {
                    if (start == 2 && before == 1 && !s.toString().contains("/")) {
                        cardExpiryEditText.setText("" + s.toString()[0]);
                        cardExpiryEditText.setSelection(1);
                    } else {
                        cardExpiryEditText.setText("$s/");
                        cardExpiryEditText.setSelection(3);
                    }
                }
            }
        })

//        val backButton = rootView.findViewById<ImageView>(com.paysky.momogrow.R.id.iv_back)
//        val appBarText =
//            rootView.findViewById<TextView>(com.paysky.momogrow.R.id.tv_store_categories)
//        backButton.setOnClickListener {
//            (context as Activity).finish()
//        }
//        val text =
//            context.obtainStyledAttributes(attrs, com.paysky.momogrow.R.styleable.CustomAppBar)
//        appBarText.text = text.getString(com.paysky.momogrow.R.styleable.CustomAppBar_android_text)

    }
}