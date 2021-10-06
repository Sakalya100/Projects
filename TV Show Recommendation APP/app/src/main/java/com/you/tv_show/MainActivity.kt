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
                    "dd963892-f7aa-4318-8c73-e0142a0f0d48\n", // your api key
                    "615d6c130b177c8b3d47e6cdQgOVw1SiCZh7K7pwGX6ZB874"  // your api key secret
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
