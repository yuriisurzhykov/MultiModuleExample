package com.yuriysurzhikov.modernui.counter

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.yuriysurzhikov.modernui.R

class CounterView : ConstraintLayout {

    private var mCount = 0
        set(value) {
            field = if (value >= 0)
                value
            else
                0
        }

    private var mCountText: TextView? = null
    private var mMinusButton: ImageView? = null
    private var mPlusButton: ImageView? = null
    private var mView: ConstraintLayout? = null

    val count: Int
        get() = mCount
    var counterChangeListener: CounterChangeListener? = null

    init {
        inflateView()
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        obtainAttrs(attributeSet)
    }
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr) {

        obtainAttrs(attributeSet)
    }

    private fun inflateView() {
        mView = LayoutInflater.from(context).inflate(R.layout.counter_view, this, true) as ConstraintLayout
        mCountText = mView?.findViewById(R.id.counter_text)
        mMinusButton = mView?.findViewById(R.id.action_minus)
        mPlusButton = mView?.findViewById(R.id.action_plus)
        mCount = 0
        mCountText?.text = mCount.toString()
        mMinusButton?.setOnClickListener {
            mCount -= 1
            mCountText?.text = mCount.toString()
            counterChangeListener?.onCountChange(mCount)
        }
        mPlusButton?.setOnClickListener {
            mCount += 1
            mCountText?.text = mCount.toString()
            counterChangeListener?.onCountChange(mCount)
        }
    }

    private fun obtainAttrs(attributeSet: AttributeSet?) {
        context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.CounterView,
            0, 0).apply {
            try {
                val defaultColor = context.resources.getColor(R.color.cardview_dark_background)
                val defaultWhite = context.resources.getColor(android.R.color.white)
                mMinusButton?.imageTintList = ColorStateList.valueOf(getColor(R.styleable.CounterView_counterIconTint, defaultColor))
                mPlusButton?.imageTintList = ColorStateList.valueOf(getColor(R.styleable.CounterView_counterIconTint, defaultColor))
                mView?.backgroundTintList = ColorStateList.valueOf(getColor(R.styleable.CounterView_counterBackground, defaultWhite))
                mCountText?.setTextColor(getColor(R.styleable.CounterView_counterTextColor, defaultColor))
            } finally {
                recycle()
            }
        }
    }
}