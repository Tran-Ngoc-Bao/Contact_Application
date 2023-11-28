package com.example.contactapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class SubFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_sub, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val identify = "Identify: " + arguments?.getString("identify")
        val name = "Name: " + arguments?.getString("name")
        val email = "Email: " + arguments?.getString("email")
        val phone = "Phone: " + arguments?.getString("phone")

        val a = view.findViewById<ImageView>(R.id.avatar).setImageResource(
            resources.getIdentifier(
                "char_${name.lowercase()[0]}",
                "mipmap",
                "com.example.contactapplication"
            )
        )
        val i = view.findViewById<TextView>(R.id.identify)
        i.text = identify
        val n = view.findViewById<TextView>(R.id.name)
        n.text = name
        val e = view.findViewById<TextView>(R.id.email)
        e.text = email
        val p = view.findViewById<TextView>(R.id.phone)
        p.text = phone
    }
}