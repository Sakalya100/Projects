package com.example.memezy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    package com.sawolabs.sdkdemo

    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.view.View
    import com.sawolabs.androidsdk.Sawo

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        }

        fun onClickLogin(view: View) {
            Sawo(
                    this,
                    "6708b8d4-267d-4076-80c7-daaba18d6387", // your api key,
                    "61601bb05e9b584a31c7e789qs6Frmr5bHOojsABF6JgYN5i" // your secret key
            ).login(
                    "phone_number_sms", // can be one of 'email' or 'phone_number_sms'
                    MainActivity::class.java.name
            )
        }
    }
}
