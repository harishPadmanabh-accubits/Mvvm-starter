package com.accubits.mvvm_starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.accubits.mvvm_starter.extensions.LoggingKeys
import com.accubits.mvvm_starter.extensions.doLogWithTag

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}