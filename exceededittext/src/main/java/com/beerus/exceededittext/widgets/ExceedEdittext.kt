package com.beerus.exceededittext.widgets

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.beerus.exceededittext.R

class ExceedEdittext @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = com.google.android.material.R.attr.editTextStyle
) : AppCompatEditText(context, attrs, defStyleAttr) {

    private var highLightColor = Color.TRANSPARENT
    private var maxCharacter = 0
    private val paintLine by lazy { Paint() }
    private val rect by lazy { Rect() }

    init {
        context.obtainStyledAttributes(attrs, R.styleable.ExceedEdittext).apply {
            highLightColor =
                getColor(R.styleable.ExceedEdittext_highLightColor, Color.TRANSPARENT)
            maxCharacter =
                getInt(R.styleable.ExceedEdittext_maxCharacter, 0)
            recycle()
        }
        paintLine.color = highLightColor
    }

    override fun onDraw(canvas: Canvas?) {
        if (length() > maxCharacter && maxCharacter != 0) {
            val lineMax = layout.getLineForOffset(maxCharacter)
            for (i in lineMax until lineCount) {
                rect.top = layout.getLineTop(i) + totalPaddingTop
                rect.left = if (i == lineMax) {
                    layout.getPrimaryHorizontal(maxCharacter).toInt() + totalPaddingStart
                } else {
                    layout.getLineLeft(i).toInt() + totalPaddingStart
                }
                rect.right = layout.getLineRight(i).toInt() + totalPaddingStart
                rect.bottom = layout.getLineBottom(i) + totalPaddingTop
                canvas?.drawRect(rect, paintLine)
            }
        }
        super.onDraw(canvas)
    }
}