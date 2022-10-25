package edu.mobcom.midtermbayas

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginactivity)

        val loginBtn: Button = findViewById(R.id.btnLogin)

        val registerBtn: Button = findViewById(R.id.btnRegister)
        val usernametxt = findViewById<EditText>(R.id.inUsername)




            loginBtn.setOnClickListener {
                val iSend = Intent(this@LoginActivity, MessageActivity::class.java)
                with(iSend) {
                    putExtra("username", usernametxt.text.toString())
                }


                    try {
                        startActivity(iSend)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(this, "Content error!", Toast.LENGTH_LONG).show()
                    }
                }

                registerBtn.setOnClickListener {
                    val iRegister = Intent(this@LoginActivity, RegisterActivity::class.java)
                    startActivity(iRegister)
                }

            }
        }

