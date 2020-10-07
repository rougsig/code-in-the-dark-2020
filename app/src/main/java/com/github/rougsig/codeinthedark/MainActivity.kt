package com.github.rougsig.codeinthedark

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.squareup.contour.ContourLayout
import splitties.dimensions.dip
import splitties.dimensions.dp
import splitties.views.dsl.core.*
import splitties.views.gravityCenter
import splitties.views.textColorResource

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
  private val tag1 = textView {
    text = "Action"
  }
  private val tag2 = textView {
    text = "Biography"
  }
  private val tag3 = textView {
    text = "Drama"
  }
  private val descTitle = textView {
    text = "Plot Summary"
  }
  private val description = textView {
    text = "American car designer Carroll Shelby and driver Kn Miles battle corporate " +
      "interference and the laws of physics to build a revolutionary race car for Ford in order."
  }
  private val crewTitle = textView {
    text = "Cast & Crew"
  }
  private val crew = horizontalLayout {
    add(crewItem(), lParams(dip(80), wrapContent))
    add(crewItem(), lParams(dip(80), wrapContent))
    add(crewItem(), lParams(dip(80), wrapContent))
    add(crewItem(), lParams(dip(80), wrapContent))
  }
  private val meta = meta()

  override val root = contourLayout {
    hero.layoutBy(
      x = parentWidth(),
      y = topTo { parent.top() }
    )
    meta.layoutBy(
      x = leftTo { parent.left() + 32.dip }.rightTo { parent.right() },
      y = topTo { hero.bottom() - 55.ydip }.heightOf { 110.ydip }
    )
    title.layoutBy(
      x = leftTo { parent.left() + 32.xdip },
      y = topTo { hero.bottom() + 102.ydip }
    )

    year.layoutBy(
      x = leftTo { parent.left() + 32.xdip },
      y = topTo { title.bottom() + 8.ydip }
    )
    pg.layoutBy(
      x = leftTo { year.right() + 32.xdip },
      y = topTo { title.bottom() + 8.ydip }
    )
    timing.layoutBy(
      x = leftTo { pg.right() + 32.xdip },
      y = topTo { title.bottom() + 8.ydip }
    )

    tag1.layoutBy(
      x = leftTo { parent.left() + 32.xdip },
      y = topTo { year.bottom() + 20.ydip }.heightOf { 36.ydip }
    )
    tag2.layoutBy(
      x = leftTo { tag1.right() + 12.xdip },
      y = topTo { year.bottom() + 20.ydip }.heightOf { 36.ydip }
    )
    tag3.layoutBy(
      x = leftTo { tag2.right() + 12.xdip },
      y = topTo { year.bottom() + 20.ydip }.heightOf { 36.ydip }
    )

    descTitle.layoutBy(
      x = parentWidth(32),
      y = topTo { tag1.bottom() + 48.ydip }
    )
    description.layoutBy(
      x = parentWidth(32),
      y = topTo { descTitle.bottom() + 16.ydip }
    )

    crewTitle.layoutBy(
      x = parentWidth(32),
      y = topTo { description.bottom() + 48.ydip }
    )
    crew.layoutBy(
      x = parentWidth(32),
      y = topTo { crewTitle.bottom() + 16.ydip }
    )

    contourHeightOf { 2000.ydip }
  }.wrapInNestedScrollView { isFillViewport = true }
}

private class CrewItem(ctx: Context) : LinearLayout(ctx) {
  private val image = imageView {
    setImageResource(R.drawable.img_person_1)
    scaleType = ImageView.ScaleType.FIT_XY
  }
  private val title = textView {
    text = "James Mangold"
    gravity = gravityCenter
  }
  private val description = textView {
    text = "Director"
    gravity = gravityCenter
  }

  init {
    orientation = VERTICAL
    add(image, lParams(dip(80), dip(80)))
    add(title, lParams(dip(80), wrapContent) {
      topMargin = dip(12)
    })
    add(description, lParams(dip(80), wrapContent) {
      topMargin = dip(4)
    })
  }
}

private inline fun Ui.crewItem(
  @IdRes id: Int = View.NO_ID,
  initView: CrewItem.() -> Unit = {}
): CrewItem {
  return view({ CrewItem(it) }, id, initView = initView)
}

private class Meta(ctx: Context) : ContourLayout(ctx) {
  init {
    elevation = dp(16)
  }

  private val starFilled = imageView {
    setImageResource(R.drawable.ic_star_filled)
  }
  private val score = textView {
    text = "8.2/10"
  }
  private val total = textView {
    text = "150,212"
  }

  private val star = imageView {
    setImageResource(R.drawable.ic_star)
  }
  private val rateThis = textView {
    text = "Rate This"
  }

  private val meta = textView {
    setBackgroundResource(R.color.green)
    textColorResource = R.color.white
    text = "86"
  }
  private val metascore = textView {
    text = "Metascore"
  }
  private val metaScoreDesc = textView {
    text = "62 critic reviews"
  }

  init {
    starFilled.layoutBy(
      x = leftTo { parent.left() + 66.dip },
      y = topTo { parent.top() + 16.dip }
    )
    score.layoutBy(
      x = centerHorizontallyTo { starFilled.centerX() },
      y = topTo { starFilled.top() + 4.dip }
    )
    total.layoutBy(
      x = centerHorizontallyTo { starFilled.centerX() },
      y = topTo { starFilled.top() + 4.dip }
    )

    star.layoutBy(
      x = leftTo { parent.left() + 205.dip },
      y = topTo { parent.top() + 16.dip }
    )
    rateThis.layoutBy(
      x = centerHorizontallyTo { star.centerX() - 24.dip },
      y = topTo { starFilled.top() + 4.dip }
    )

    meta.layoutBy(
      x = leftTo { parent.left() + 344.dip },
      y = topTo { parent.top() + 16.dip }
    )
    metascore.layoutBy(
      x = centerHorizontallyTo { meta.centerX() - 24.dip },
      y = topTo { starFilled.top() + 4.dip }
    )
    metaScoreDesc.layoutBy(
      x = centerHorizontallyTo { meta.centerX() - 24.dip },
      y = topTo { starFilled.top() + 4.dip }
    )
  }
}

private inline fun Ui.meta(
  @IdRes id: Int = View.NO_ID,
  initView: Meta.() -> Unit = {}
): Meta {
  return view({ Meta(it) }, id, initView = initView)
}
