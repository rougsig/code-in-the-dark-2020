package com.github.rougsig.codeinthedark

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.github.rougsig.codeinthedark.RoundCornersOutlineProvider.CornerType
import splitties.dimensions.dip
import splitties.views.dsl.core.Ui
import splitties.views.dsl.core.imageView
import splitties.views.dsl.core.textView

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(MainActivityUi(this).root)
  }
}

private class MainActivityUi(override val ctx: Context) : Ui {
  private val title = textView {
    style(TextStyle.Headline1)
    text = "Hello World"
  }

  private val image = imageView {
    setImageResource(R.drawable.ic_launcher_background)
    scaleType = ImageView.ScaleType.FIT_XY
    outlineProvider = RoundCornersOutlineProvider(dip(16), CornerType.AllSides)
    clipToOutline = true
  }

  override val root = contourLayout {
    image.layoutBy(
      x = parentWidth(16),
      y = topTo { parent.top() + 16.dip }
    )
    title.layoutBy(
      x = centerHorizontallyTo { parent.centerX() },
      y = centerVerticallyTo { parent.centerY() + image.height() / 2 }
    )
  }
}
