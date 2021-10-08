package com.example.calculate_me_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sawolabs.androidsdk.Sawo


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun onClickLogin(view: View) {
        Sawo(
            this,
            "5ee1eb34-de3b-4d91-9259-59da86e75653", // your api key,
            "616018285e9b584a31c7e783GJ2AJI7qiwp47vRAeGbpIeP8" // your secret key
        ).login(
            "email", // can be one of 'email' or 'phone_number_sms'
            CallbackActivity::class.java.name // Callback class name
        )
    }
}
