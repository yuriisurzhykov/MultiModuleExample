package com.yuriysurzhikov.multimoduleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.yuriysurzhikov.modernui.counter.CounterChangeListener
import com.yuriysurzhikov.modernui.counter.CounterView

class FirstActivity : AppCompatActivity(), CounterChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val counter = findViewById<CounterView>(R.id.counter_view)
        counter.counterChangeListener = this
    }

    override fun onCountChange(count: Int) {
        findViewById<TextView>(R.id.output_text).text = count.toString()
    }
}