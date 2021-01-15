package com.yuriysurzhikov.modernui.expandable.textview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class ExpandableTextView: AppCompatTextView {

    var onCollapsedListener: OnCollapsedListener? = null
    var onExpandableTextView: OnExpandedListener? = null

    private var maxLinesDefault: Int = 4
    private var isExpanded = false

    constructor(context: Context): super(context) {
        initDefault()
    }
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet) {
        initWithAttrs(attributeSet)
    }

    fun setExpandedText(text: String?) {

    }

    fun setExpandedText(textRes: Int) {

    }

    fun setHintButtonText(text: String?) {

    }

    fun setHintButtonText(textRes: Int) {

    }

    private fun initDefault() {
        this.maxLines = maxLinesDefault
    }

    private fun initWithAttrs(attributeSet: AttributeSet) {

    }

    private fun setupListener() {

    }
}