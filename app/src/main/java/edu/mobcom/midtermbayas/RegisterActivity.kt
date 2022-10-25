package edu.mobcom.midtermbayas

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val logoutBtn: Button = findViewById(R.id.btnlblLogoutoLogin)
        val rReg: Button = findViewById(R.id.btnlblRegister)
        val rIdnum = findViewById<EditText>(R.id.inIdNum)
        val rFirstN= findViewById<EditText>(R.id.inIdNum)
        val rLastN = findViewById<EditText>(R.id.inIdNum)
        val rEmailA = findViewById<EditText>(R.id.inIdNum)
        val rPass = findViewById<EditText>(R.id.inIdNum)
        val rConP = findViewById<EditText>(R.id.inIdNum)


        rReg.setOnClickListener {
            val iReg = Intent(this@RegisterActivity, ProfileActivity::class.java)
            with(iReg){
                putExtra("ID", rIdnum.text.toString())
                putExtra("FirstN", rFirstN.text.toString())
                putExtra("LastN", rLastN.text.toString())
                putExtra("EmailA", rEmailA.text.toString())
                putExtra("Pass", rPass.text.toString())
                putExtra("ConP", rConP.text.toString())
            }


            val print: String = "${rIdnum.text.toString()} ${rFirstN.text.toString()} ${rLastN.text.toString()} ${rEmailA.text.toString()} ${rPass.text.toString()} ${rConP.text.toString()}"
            try {
                Toast.makeText(this, print, Toast.LENGTH_LONG).show()
                startActivity(iReg)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Content error!", Toast.LENGTH_LONG).show()
            }

        }
        logoutBtn.setOnClickListener {
            val iBack = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(iBack)
        }


    }
}