package com.example.reezkyillma.kotlinlatihantiga

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.jetbrains.anko.toast

class AfterLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_login)

        var username = intent.getStringExtra("username")
        var uname: TextView = findViewById(R.id.tv_usernameafterlogin)
        toast("Anda berhasil login")
        uname.text = username
    }
}
