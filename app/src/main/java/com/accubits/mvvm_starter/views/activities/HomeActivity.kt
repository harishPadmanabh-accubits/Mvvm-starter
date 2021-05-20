package com.accubits.mvvm_starter.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.accubits.mvvm_starter.R
import com.accubits.mvvm_starter.extensions.obtainViewModel
import com.accubits.mvvm_starter.viewmodels.AuthViewModel

class HomeActivity : AppCompatActivity() {

    private  lateinit var authViewModel:AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        authViewModel = obtainViewModel(AuthViewModel::class.java)
    }
}