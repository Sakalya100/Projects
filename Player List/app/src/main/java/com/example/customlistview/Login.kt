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
                "30bd96f6-1c17-46a5-9a40-af0f6d2672b1", // your api key,
                "61601f45956fa888e2ab655c1gifLsR4z9wT6muDcA1GN0Mp" // your secret key
            ).login(
                "email", // can be one of 'email' or 'phone_number_sms'
                CallbackActivity::class.java.name // Callback class name
            )
        }
    }
}
