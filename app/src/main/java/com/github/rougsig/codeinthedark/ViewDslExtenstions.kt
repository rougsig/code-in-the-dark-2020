package com.github.rougsig.codeinthedark

import android.view.View
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import androidx.core.widget.NestedScrollView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.epoxy.EpoxyRecyclerView
import com.squareup.contour.ContourLayout
import com.squareup.contour.solvers.XAxisSolver
import com.squareup.contour.solvers.YAxisSolver
import splitties.views.dsl.core.NO_THEME
import splitties.views.dsl.core.Ui
import splitties.views.dsl.core.add
import splitties.views.dsl.core.view

inline fun Ui.epoxyRecyclerView(
    @IdRes id: Int = View.NO_ID,
    initView: EpoxyRecyclerView.() -> Unit = {}
): EpoxyRecyclerView {
    return view({ EpoxyRecyclerView(it) }, id, initView = initView)
}

inline fun Ui.contourLayout(
    @IdRes id: Int = View.NO_ID,
    initView: ContourLayout.() -> Unit = {}
): ContourLayout {
    return view({ ContourLayout(it) }, id, initView = initView)
}

fun ContourLayout.parentWidth(leftMargin: Int = 0, rightMargin: Int = leftMargin): XAxisSolver {
    return leftTo { parent.left() + leftMargin.xdip }.rightTo { parent.right() - rightMargin.xdip }
}

fun ContourLayout.parentHeight(marginDp: Int = 0): YAxisSolver {
    return topTo { parent.top() + marginDp.ydip }.bottomTo { parent.bottom() - marginDp.ydip }
}

fun View.wrapInSwipeRefreshLayout(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = NO_THEME,
    initView: SwipeRefreshLayout.() -> Unit = {}
): SwipeRefreshLayout {
    val layout = view(::SwipeRefreshLayout, id, theme, initView)
    layout.add(this, LayoutParams(MATCH_PARENT, WRAP_CONTENT))
    return layout
}

fun View.wrapInNestedScrollView(
    @IdRes id: Int = View.NO_ID,
    initView: NestedScrollView.() -> Unit = {}
): NestedScrollView {
    val scrollView = view(::NestedScrollView, id, initView = initView)
    scrollView.add(this, LayoutParams(MATCH_PARENT, WRAP_CONTENT))
    return scrollView
}
