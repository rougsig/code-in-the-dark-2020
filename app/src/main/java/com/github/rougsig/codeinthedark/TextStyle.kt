package com.github.rougsig.codeinthedark

import android.widget.TextView
import com.airbnb.paris.extensions.*

enum class TextStyle {
  Headline1,
  Headline2,
  Headline3,
  Headline4,
  Headline5,
  Subtitle1,
  Subtitle2,
  Body1,
  Body2,
  Body3,
  Body4,
  Body5,
  Caption1,
  Caption2,
  Caption3,
  Caption4;

  companion object {
    val headline1 = textViewStyle {
      textSizeRes(R.dimen.size_40_sp)
      lineHeightRes(R.dimen.size_58_sp)
      fontFamilyRes(R.font.montserrat_bold)
    }
    val headline2 = textViewStyle {
      textSizeRes(R.dimen.size_40_sp)
      lineHeightRes(R.dimen.size_58_sp)
      fontFamilyRes(R.font.proxima_nova_light)
    }
    val headline3 = textViewStyle {
      textSizeRes(R.dimen.size_24_sp)
      lineHeightRes(R.dimen.size_32_sp)
      fontFamilyRes(R.font.proxima_nova_light)
    }
    val headline4 = textViewStyle {
      textSizeRes(R.dimen.size_24_sp)
      lineHeightRes(R.dimen.size_32_sp)
      fontFamilyRes(R.font.proxima_nova_bold)
    }
    val headline5 = textViewStyle {
      textSizeRes(R.dimen.size_24_sp)
      lineHeightRes(R.dimen.size_32_sp)
      fontFamilyRes(R.font.montserrat_bold)
    }

    val subtitle1 = textViewStyle {
      textSizeRes(R.dimen.size_18_sp)
      lineHeightRes(R.dimen.size_28_sp)
      fontFamilyRes(R.font.proxima_nova_bold)
    }
    val subtitle2 = textViewStyle {
      textSizeRes(R.dimen.size_18_sp)
      lineHeightRes(R.dimen.size_28_sp)
      fontFamilyRes(R.font.montserrat_bold)
    }

    val body1 = textViewStyle {
      textSizeRes(R.dimen.size_16_sp)
      lineHeightRes(R.dimen.size_24_sp)
      fontFamilyRes(R.font.proxima_nova_light)
    }
    val body2 = textViewStyle {
      textSizeRes(R.dimen.size_16_sp)
      lineHeightRes(R.dimen.size_24_sp)
      fontFamilyRes(R.font.proxima_nova_regular)
    }
    val body3 = textViewStyle {
      textSizeRes(R.dimen.size_16_sp)
      lineHeightRes(R.dimen.size_24_sp)
      fontFamilyRes(R.font.proxima_nova_bold)
    }
    val body4 = textViewStyle {
      textSizeRes(R.dimen.size_14_sp)
      lineHeightRes(R.dimen.size_18_sp)
      fontFamilyRes(R.font.proxima_nova_light)
    }
    val body5 = textViewStyle {
      textSizeRes(R.dimen.size_14_sp)
      lineHeightRes(R.dimen.size_18_sp)
      fontFamilyRes(R.font.proxima_nova_bold)
    }

    val caption1 = textViewStyle {
      textSizeRes(R.dimen.size_12_sp)
      lineHeightRes(R.dimen.size_16_sp)
      fontFamilyRes(R.font.proxima_nova_light)
    }
    val caption2 = textViewStyle {
      textSizeRes(R.dimen.size_12_sp)
      lineHeightRes(R.dimen.size_16_sp)
      fontFamilyRes(R.font.proxima_nova_regular)
    }
    val caption3 = textViewStyle {
      textSizeRes(R.dimen.size_12_sp)
      lineHeightRes(R.dimen.size_16_sp)
      fontFamilyRes(R.font.montserrat_bold)
    }
    val caption4 = textViewStyle {
      textSizeRes(R.dimen.size_10_sp)
      lineHeightRes(R.dimen.size_16_sp)
      fontFamilyRes(R.font.proxima_nova_light)
    }
  }
}

@Suppress("ComplexMethod")
fun TextView.style(style: TextStyle) {
  when (style) {
    TextStyle.Headline1 -> style(TextStyle.headline1)
    TextStyle.Headline2 -> style(TextStyle.headline2)
    TextStyle.Headline3 -> style(TextStyle.headline3)
    TextStyle.Headline4 -> style(TextStyle.headline4)
    TextStyle.Headline5 -> style(TextStyle.headline5)
    TextStyle.Subtitle1 -> style(TextStyle.subtitle1)
    TextStyle.Subtitle2 -> style(TextStyle.subtitle2)
    TextStyle.Body1 -> style(TextStyle.body1)
    TextStyle.Body2 -> style(TextStyle.body2)
    TextStyle.Body3 -> style(TextStyle.body3)
    TextStyle.Body4 -> style(TextStyle.body4)
    TextStyle.Body5 -> style(TextStyle.body5)
    TextStyle.Caption1 -> style(TextStyle.caption1)
    TextStyle.Caption2 -> style(TextStyle.caption2)
    TextStyle.Caption3 -> style(TextStyle.caption3)
    TextStyle.Caption4 -> style(TextStyle.caption4)
  }.exhaustive
}
