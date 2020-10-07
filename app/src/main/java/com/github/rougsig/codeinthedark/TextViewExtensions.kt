package com.github.rougsig.codeinthedark

import android.graphics.drawable.Drawable
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun TextView.setLeftDrawableTint(
  @ColorRes colorRes: Int?
) {
  compoundDrawables[0]?.let { drawable ->
    val color = colorRes?.let { context.getColorCompat(it) }
    if (color != null) drawable.setTint(color)
    else drawable.clearColorFilter()
  }
}

fun TextView.setRightDrawableTint(
  @ColorRes colorRes: Int?
) {
  compoundDrawables[2]?.let { drawable ->
    val color = colorRes?.let { context.getColorCompat(it) }
    if (color != null) drawable.setTint(color)
    else drawable.clearColorFilter()
  }
}

fun TextView.setDrawable(
  @DrawableRes left: Int? = null,
  @DrawableRes top: Int? = null,
  @DrawableRes right: Int? = null,
  @DrawableRes bottom: Int? = null
) {
  val compoundDrawables = compoundDrawables
  setCompoundDrawablesWithIntrinsicBounds(
    getDrawable(left) ?: compoundDrawables[0],
    getDrawable(top) ?: compoundDrawables[1],
    getDrawable(right) ?: compoundDrawables[2],
    getDrawable(bottom) ?: compoundDrawables[3]
  )
}

private fun TextView.getDrawable(res: Int?): Drawable? {
  return if (res == null || res == 0) null
  else ContextCompat.getDrawable(context, res)
}

fun TextView.clearAllDrawables() {
  setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
}

fun TextView.clearLeftDrawable() {
  val compoundDrawables = compoundDrawables
  setCompoundDrawablesWithIntrinsicBounds(
    null,
    compoundDrawables[1],
    compoundDrawables[2],
    compoundDrawables[3]
  )
}

fun TextView.clearTopDrawable() {
  val compoundDrawables = compoundDrawables
  setCompoundDrawablesWithIntrinsicBounds(
    compoundDrawables[0],
    null,
    compoundDrawables[2],
    compoundDrawables[3]
  )
}

fun TextView.clearRightDrawable() {
  val compoundDrawables = compoundDrawables
  setCompoundDrawablesWithIntrinsicBounds(
    compoundDrawables[0],
    compoundDrawables[1],
    null,
    compoundDrawables[3]
  )
}

fun TextView.clearBottomDrawable() {
  val compoundDrawables = compoundDrawables
  setCompoundDrawablesWithIntrinsicBounds(
    compoundDrawables[0],
    compoundDrawables[1],
    compoundDrawables[2],
    null
  )
}
