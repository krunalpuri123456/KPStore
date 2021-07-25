package com.example.kpstore.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.graphics.DashPathEffect

/**
 * A custom EditText that draws lines between each line of text that is displayed.
 */
class LinedEditText// we need this constructor for LayoutInflater
    (context: Context, attrs: AttributeSet) : androidx.appcompat.widget.AppCompatEditText(context, attrs) {
    private val mRect: Rect
    private val mPaint: Paint

    init {

        mRect = Rect()
        mPaint = Paint()
        mPaint.setStyle(Paint.Style.STROKE)
        mPaint.setColor(-0x7fffff01)
        val effects = DashPathEffect(floatArrayOf(3f, 3f, 3f, 3f), 1f)
        mPaint.setPathEffect(effects)
    }


    override fun onDraw(canvas: Canvas) {

        val height = height
        val line_height = lineHeight

        var count = height / line_height

        if (lineCount > count)
            count = lineCount//for long text with scrolling

        val r = mRect
        val paint = mPaint
        var baseline = getLineBounds(0, r)//first line

        for (i in 0 until count) {

            canvas.drawLine(r.left.toFloat(), (baseline + 1).toFloat(), r.right.toFloat(), (baseline + 1).toFloat(), paint)
            baseline += lineHeight//next line
        }

        super.onDraw(canvas)
    }
}