package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customlistview.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUserBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra( "name")
        val country = intent.getStringExtra( "country")
        val pos = intent.getStringExtra( "position")
        val club = intent.getStringExtra("club")
        val imageId = intent.getIntExtra("imageId",R.drawable.messi)

        binding.nameprofile.text = name
        binding.positionprofile.text = pos
        binding.clubprofile.text = club
        binding.profileImage.setImageResource(imageId)
    }
}