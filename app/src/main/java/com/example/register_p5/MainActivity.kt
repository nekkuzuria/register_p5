package com.example.register_p5

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.Toast
import com.example.register_p5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        with(binding){
            val spannable = SpannableString(byChecking.text)
            val blue = ForegroundColorSpan(Color.BLUE)
            spannable.setSpan(blue, 36, 42, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            spannable.setSpan(blue, 47, 57, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            byChecking.text = spannable


            registerButton.setOnClickListener(){
                if(username.text.toString().isEmpty() ||
                    password.text.toString().isEmpty() ||
                    phone.text.toString().isEmpty() ||
                    email.text.toString().isEmpty()){
                    Toast.makeText(this@MainActivity, "Mohon lengkapi semua field", Toast.LENGTH_SHORT).show()
                }
                else if(!checkbox.isChecked()){
                    Toast.makeText(this@MainActivity, "Mohon setujui Terms dan Conditions", Toast.LENGTH_SHORT).show()
                }
                else {
                    val intentToHomepage = Intent(this@MainActivity, HomepageActivity::class.java)
                    intentToHomepage.putExtra(EXTRA_USERNAME, username.text.toString())
                    intentToHomepage.putExtra(EXTRA_EMAIL, email.text.toString())
                    intentToHomepage.putExtra(EXTRA_PHONE, phone.text.toString())
                    startActivity(intentToHomepage)

                    username.setText("")
                    email.setText("")
                    phone.setText("")
                    password.setText("")
                }
            }
        }
    }
}