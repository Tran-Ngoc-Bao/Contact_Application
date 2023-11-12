package com.example.contactapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class SubActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val identify = "Identify: " + intent.getStringExtra("identify")
        val name = "Name: " + intent.getStringExtra("name")
        val email = "Email: " + intent.getStringExtra("email")
        val phone = "Phone: " + intent.getStringExtra("phone")

        val a = findViewById<ImageView>(R.id.avatar).setImageResource(
            resources.getIdentifier(
                "char_${name.lowercase()[0]}",
                "mipmap",
                packageName
            )
        )
        val i = findViewById<TextView>(R.id.identify)
        i.text = identify
        val n = findViewById<TextView>(R.id.name)
        n.text = name
        val e = findViewById<TextView>(R.id.email)
        e.text = email
        val p = findViewById<TextView>(R.id.phone)
        p.text = phone
    }
}