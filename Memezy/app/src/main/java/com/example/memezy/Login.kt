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
                    "00fa360a-af38-4b1e-9553-a50f820bdd65\n", // your api key,
                    "615d8dba956fa888e2ab62dfjmw8vOnLB5HHXy1ZatetwPDn" // your secret key
            ).login(
                    "phone_number_sms", // can be one of 'email' or 'phone_number_sms'
                    MainActivity::class.java.name
            )
        }
    }
}