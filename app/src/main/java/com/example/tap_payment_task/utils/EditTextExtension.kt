package com.example.tap_payment_task.utils

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
/**
 *
 * Extension function on EditText to be able to enter MM/YY automatically
 * without need to handle it from UI
 *
 */
fun EditText.handleEnteringExpiryFieldsAutomatically() {
    with(this@handleEnteringExpiryFieldsAutomatically) {
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 2) {
                    if (start == 2 && before == 1 && !s.toString().contains("/")) {
                        setText("" + s.toString()[0]);
                        setSelection(1);
                    } else {
                        setText("$s/");
                        setSelection(3);
                    }
                }
            }
        })
    }
}