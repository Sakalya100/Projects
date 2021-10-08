package com.you.tv_show

import android.widget.RadioButton
import com.you.tv_show.pages.base.BaseActivity


class MainActivity : BaseActivity()
{
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            Sawo(
                    this,
                    "9b5b5b0c-a398-4d6a-9366-5d7745207346", // your api key
                    "6160168f0b177c8b3d47e83bv99vwB0Kwc3JeAWuSHARXaut"  // your api key secret
            ).login(
                    "email", // can be one of 'email' or 'phone_number_sms'
                    App::class.java.name // App class name
            )
        }
    }
    private var TAG = "MainActivity"

    private var rbHome: RadioButton? = null
    private var rbLive: RadioButton? = null
    private var rbFollw: RadioButton? = null
    private var rbMe: RadioButton? = null


    override fun getRootViewId(): Int
    {
        return R.layout.activity_main
    }

    override fun initView()
    {
        rbHome = findViewById(R.id.rbHome) as RadioButton?
        rbLive = findViewById(R.id.rbLive) as RadioButton?
        rbFollw = findViewById(R.id.rbFollw) as RadioButton?
        rbMe = findViewById(R.id.rbMe) as RadioButton?
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object
    {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
