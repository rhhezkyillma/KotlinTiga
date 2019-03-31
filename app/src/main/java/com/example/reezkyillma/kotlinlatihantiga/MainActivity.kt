package com.example.reezkyillma.kotlinlatihantiga

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() , AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginView().setContentView(this)

        var btn: Button = findViewById(R.id.btnn)
        var tv_register: TextView = findViewById(R.id.tv_caa)


        var uname: EditText = findViewById(R.id.et_username)
        var passwd: EditText = findViewById(R.id.et_password)
        btn.setOnClickListener {
            val username = uname.text.toString().trim()
            val password = passwd.text.toString().trim()
            HandleLogin(username, password)
        }
        tv_register.setOnClickListener {
            startActivity(intentFor<Register>())
        }


    }

    private fun HandleLogin(username: String, password: String) {
        if (username.equals("reezky") && password.equals("reezkyillma")) {
            info { "Data username : $username, Data password : $password, Status login : Berhasil" }
            startActivity(intentFor<AfterLogin>("username" to username))
            finish()
        } else {
            error { "Data username : $username, Data password : $password, Status login : Gagal" }
            alert(title = "Warning", message = "Username atau password salah") {
                positiveButton(buttonText = "Tutup") {
                    //
                }
                isCancelable = false
            }.show()
        }
    }

    class LoginView() : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                    margin = 15
                    background = resources.getDrawable(R.drawable.gradienttiga)
                    verticalGravity = Gravity.CENTER
                }

                verticalLayout {
                    lparams {
                        width = matchParent
                        height = wrapContent
                        padding = 30
                        margin = 15
                        background = resources.getDrawable(R.drawable.gradienttiga)

                    }



                textView {
                    hint = "LOGIN"
                    textSize = 25f //tipedata float
                    textColor = Color.CYAN
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER

                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                }

                textView {
                    id = R.id.tv_username
                    text = "Email"
                    textAlignment = TextView.TEXT_ALIGNMENT_TEXT_START
                    typeface = Typeface.DEFAULT_BOLD
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    bottomMargin = 0
                }
                editText {
                    id = R.id.et_username
                    hint = "Username"
                    inputType = InputType.TYPE_CLASS_TEXT
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = 0
                    margin = 15
                }
                textView {
                    id = R.id.tv_password
                    text = "Password"
                    textAlignment = TextView.TEXT_ALIGNMENT_TEXT_START
                    typeface = Typeface.DEFAULT_BOLD
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    bottomMargin = 0
                }
                editText {
                    id = R.id.et_password
                    hint = "Password"
                    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    visibility = View.VISIBLE
                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = 0
                    margin = 15
                }
                button("LOGIN") {
                    id = R.id.btnn
                    backgroundColor = R.color.light_blue_500
                    textColor = Color.WHITE
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = 15
                    gravity = Gravity.CENTER
                }
                textView {
                    id = R.id.tv_caa
                    text = "Create Account ?"
                    textSize = 15f //tipedata float
                    textColor = R.color.deep_purple_500
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER

                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
            }

        }
        }

    }
}
