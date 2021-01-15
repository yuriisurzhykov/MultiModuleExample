package com.yuriysurzhikov.modernui.chipsedittext

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

class ChipsEditText: ConstraintLayout {

    var cancelClickListener: CancelClickListener? = null
    var inputChangesListener: InputChangesListener? = null

    constructor(context: Context): super(context) {
        initView()
    }
    constructor(context: Context, attributeSet: AttributeSet?): super(context, attributeSet, 0) {
        initView()
    }
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int): super(context, attributeSet, defStyleAttr) {
        initView()
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }

    private fun initView() {

    }
}