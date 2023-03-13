package com.example.tap_payment_task.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import androidx.core.content.ContextCompat
import br.com.simplepass.loadingbutton.animatedDrawables.ProgressType
import br.com.simplepass.loadingbutton.customViews.CircularProgressButton
import br.com.simplepass.loadingbutton.customViews.ProgressButton
import com.example.tap_payment_task.R

/**
 * This is extension class for Progress Button
 */

/**
 *  revert time will be in 2 seconds
 */
const val revertTimeConstant = 2000L
const val doneTimeConstant = 2000L

fun CircularProgressButton.morphAndRevert(
    revertTime: Long = revertTimeConstant,
    onAnimationEnd: () -> Unit = {}
) {
    startAnimation()
    Handler().run {
        postDelayed({
            revertAnimation()
            onAnimationEnd.invoke()
        }, revertTime)
    }


}

private fun defaultColor(context: Context) = ContextCompat.getColor(context, android.R.color.black)
private fun defaultDoneImage(resources: Resources) =
    BitmapFactory.decodeResource(resources, R.drawable.visa_logo)

private fun ProgressButton.morphDoneAndRevert(
    context: Context,
    fillColor: Int = defaultColor(context),
    bitmap: Bitmap = defaultDoneImage(context.resources),
    doneTime: Long = doneTimeConstant,
    revertTime: Long = revertTimeConstant
) {
    progressType = ProgressType.INDETERMINATE
    startAnimation()
    Handler().run {
        postDelayed({ doneLoadingAnimation(fillColor, bitmap) }, doneTime)
        postDelayed(::revertAnimation, revertTime)
    }
}