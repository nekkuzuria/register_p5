package com.example.register_p5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.register_p5.databinding.HomepageBinding

class HomepageActivity : AppCompatActivity() {
    private lateinit var binding: HomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = HomepageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            val username = intent.getStringExtra(MainActivity.EXTRA_USERNAME)
            val email = intent.getStringExtra(MainActivity.EXTRA_EMAIL)
            val phone = intent.getStringExtra(MainActivity.EXTRA_PHONE)

            welcome.text = "Welcome $username \nYour $email has been activated \nYour $phone has been registered"

            logoutButton.setOnClickListener(){
                finish()
            }
        }
    }
}