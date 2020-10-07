package com.github.rougsig.codeinthedark

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider

class RoundCornersOutlineProvider(
  private val radiusPx: Int,
  private val cornerType: CornerType
) : ViewOutlineProvider() {
  enum class CornerType { TopSide, RightSide, BottomSide, LeftSide, AllSides }

  override fun getOutline(view: View, outline: Outline) {
    val left: Int
    val right: Int
    val top: Int
    val bottom: Int

    when (cornerType) {
      CornerType.TopSide -> {
        top = 0
        right = view.width
        bottom = view.height + radiusPx
        left = 0
      }
      CornerType.RightSide -> {
        top = 0
        right = view.width
        bottom = view.height
        left = -radiusPx
      }
      CornerType.BottomSide -> {
        top = -radiusPx
        right = view.width
        bottom = view.height
        left = 0
      }
      CornerType.LeftSide -> {
        top = 0
        right = view.width + radiusPx
        bottom = view.height
        left = 0
      }
      CornerType.AllSides -> {
        top = 0
        right = view.width
        bottom = view.height
        left = 0
      }
    }

    outline.setRoundRect(left, top, right, bottom, radiusPx.toFloat())
  }
}
