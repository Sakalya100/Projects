package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
package com.sawolabs.sdkdemo

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
                "1ea300ca-49c5-40dd-bdff-72d9e6c545fb\n", // your api key,
                "615d8fc5956fa888e2ab62e1OlOki1VoTpi7Yg2RTtc8cMm9" // your secret key
            ).login(
                "email", // can be one of 'email' or 'phone_number_sms'
                CallbackActivity::class.java.name // Callback class name
            )
        }
    }
}