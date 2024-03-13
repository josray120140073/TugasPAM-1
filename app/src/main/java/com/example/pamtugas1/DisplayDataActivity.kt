package com.example.pamtugas1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.pamtugas1.R

class DisplayDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Detail Data"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        // Get the data from the intent
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val gender = intent.getStringExtra("gender")
        val status = intent.getStringExtra("status")
        val tosChecked = intent.getBooleanExtra("tos_checked", false)
        val newsletterChecked = intent.getBooleanExtra("newsletter_checked", false)
        val agreeChecked = intent.getBooleanExtra("agree_checked", false)

        // Find the TextViews to display the data
        val textViewName = findViewById<TextView>(R.id.textViewName)
        val textViewEmail = findViewById<TextView>(R.id.textViewEmail)
        val textViewPhone = findViewById<TextView>(R.id.textViewPhone)
        val textViewGender = findViewById<TextView>(R.id.textViewGender)
        val textViewStatus = findViewById<TextView>(R.id.textViewStatus)
        val textViewTos = findViewById<TextView>(R.id.textViewTos)
        val textViewNewsletter = findViewById<TextView>(R.id.textViewNewsletter)
        val textViewAgree = findViewById<TextView>(R.id.textViewAgree)

        // Set the text of the TextViews
        textViewName.text = getString(R.string.name, name)
        textViewEmail.text = getString(R.string.email, email)
        textViewPhone.text = getString(R.string.phone, phone)
        textViewGender.text = getString(R.string.gender, gender)
        textViewStatus.text = getString(R.string.status, status)
    }

}