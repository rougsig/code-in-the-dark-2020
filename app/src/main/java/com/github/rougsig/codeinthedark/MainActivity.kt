package com.github.rougsig.codeinthedark

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
  private val hero = imageView {
    setImageResource(R.drawable.hero_img)
  }

  private val info = contourLayout {

  }

  private val title = textView {
    text = "Ford v Ferrari"
    setSingleLine()
  }
  private val year = textView {
    text = "2019"
  }
  private val pg = textView {
    text = "PG-13"
  }
  private val timing = textView {
    text = "2h 32min"
  }


  override val root = contourLayout {
    hero.layoutBy(
      x = parentWidth(),
      y = topTo { parent.top() }
    )
    title.layoutBy(
      x = leftTo { parent.left() + 32.xdip },
      y = topTo { hero.bottom() + 102.ydip }
    )

    contourHeightOf { 2000.ydip }
  }.wrapInNestedScrollView { isFillViewport = true }
}
