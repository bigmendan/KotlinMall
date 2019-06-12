package com.kotlin.base.widgets

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class LinearItemDecoration(context: Context, orientation: Int) : RecyclerView.ItemDecoration() {
    private val mDivider: Drawable?
    private var mOrientation: Int = 0

    init {
        val a = context.obtainStyledAttributes(ATTRS)
        this.mDivider = a.getDrawable(0)
        a.recycle()
        this.setOrientation(orientation)
    }

    private fun setOrientation(orientation: Int) {
        this.mOrientation = orientation
    }

    override fun onDraw(c: Canvas, parent: RecyclerView) {
        if (this.mOrientation == 1) {
            this.drawVertical(c, parent)
        } else {
            this.drawHorizontal(c, parent)
        }

    }

    fun drawVertical(c: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.childCount

        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + this.mDivider!!.intrinsicHeight
            this.mDivider.setBounds(left, top, right, bottom)
            this.mDivider.draw(c)
        }

    }

    private fun drawHorizontal(c: Canvas, parent: RecyclerView) {
        val top = parent.paddingTop
        val bottom = parent.height - parent.paddingBottom
        val childCount = parent.childCount

        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val left = child.right + params.rightMargin
            val right = left + this.mDivider!!.intrinsicHeight
            this.mDivider.setBounds(left, top, right, bottom)
            this.mDivider.draw(c)
        }

    }

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        if (this.mOrientation == 1) {
            outRect.set(0, 0, 0, this.mDivider!!.intrinsicHeight)
        } else {
            outRect.set(0, 0, this.mDivider!!.intrinsicWidth, 0)
        }

    }

    companion object {

        private val ATTRS = intArrayOf(16843284)
        val HORIZONTAL_LIST = 0
        val VERTICAL_LIST = 1
    }
}
