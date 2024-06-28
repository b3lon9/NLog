package com.donguran.nlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private var message: String = "test message hello"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NLog.v(message)
        NLog.i(message)
        NLog.d(message)
        NLog.w(message)
        NLog.e(message)
    }

    override fun onResume() {
        super.onResume()
        NLog.configure(tag = "donguran", isPath = true)
        message = "test message greeting"
        NLog.v(message)
        NLog.i(message)
        NLog.d(message)
        NLog.w(message)
        NLog.e(message)
    }
}