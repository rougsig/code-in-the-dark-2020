package com.github.rougsig.codeinthedark

import android.content.Context
import android.content.res.ColorStateList
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.withStyledAttributes

@ColorInt
fun Context.getColorFromAttribute(@AttrRes attr: Int): Int {
  this.withStyledAttributes(attrs = intArrayOf(attr)) {
    return this.getColor(0, 0)
  }
  return 0
}

@DrawableRes
fun Context.getDrawableResourceFromAttribute(@AttrRes attr: Int): Int {
  val tv = TypedValue()
  theme.resolveAttribute(attr, tv, true)
  return tv.resourceId
}

@ColorInt
fun Context.getColorCompat(@ColorRes colorRes: Int): Int {
  return resources.getColorCompat(colorRes)
}

fun Context.getColorStateListCompat(@ColorRes colorRes: Int): ColorStateList {
  return resources.getColorStateListCompat(colorRes)
}

@DrawableRes
fun Context.getSelectableItemBackgroundResource(): Int {
  val tv = TypedValue()
  theme.resolveAttribute(android.R.attr.selectableItemBackground, tv, true)
  return tv.resourceId
}

@DrawableRes
fun Context.getSelectableItemBackgroundBorderlessResource(): Int {
  val tv = TypedValue()
  theme.resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, tv, true)
  return tv.resourceId
}

val Context.screenWidth: Int
  get() {
    return resources.displayMetrics.widthPixels
  }

val Context.screenHeight: Int
  get() {
    return resources.displayMetrics.heightPixels
  }

