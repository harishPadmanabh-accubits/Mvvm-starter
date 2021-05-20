package com.accubits.mvvm_starter.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.accubits.mvvm_starter.R
import com.accubits.mvvm_starter.extensions.openActivity
import com.accubits.mvvm_starter.extensions.show
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onClick(view: View) {
        when(view.id){
            R.id.btn_login_cta->{
             loginUser()
            }
            R.id.btn_signup->{
                openActivity(RegistrationActivity::class.java)
            }
            R.id.btn_use_password->{
                til_password.show()
            }
        }
    }

    private fun loginUser() {
        TODO("Not yet implemented")
    }

}