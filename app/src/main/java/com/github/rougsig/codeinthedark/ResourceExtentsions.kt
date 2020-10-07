package com.github.rougsig.codeinthedark

import android.content.res.ColorStateList
import android.content.res.Resources
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat

@ColorInt
fun Resources.getColorCompat(@ColorRes colorRes: Int): Int {
  return ResourcesCompat.getColor(this, colorRes, null)
}

fun Resources.getColorStateListCompat(@ColorRes colorRes: Int): ColorStateList {
  return ResourcesCompat.getColorStateList(this, colorRes, null)!!
}

fun Resources.getStringOrNull(@StringRes stringRes: Int): String? {
  return if (stringRes != 0) getString(stringRes) else null
}

fun Resources.getStringOrDefault(@StringRes stringRes: Int, defaultText: String): String {
  return if (stringRes != 0) getString(stringRes) else defaultText
}

fun Resources.getStringOrDefault(@StringRes stringRes: Int, @StringRes defaultRes: Int): String {
  return if (stringRes != 0) getString(stringRes) else getString(defaultRes)
}

fun Resources.getStatusBarHeight(): Int {
  val resId = getIdentifier("status_bar_height", "dimen", "android")
  return if (resId > 0) {
    getDimensionPixelSize(resId)
  } else {
    0
  }
}
