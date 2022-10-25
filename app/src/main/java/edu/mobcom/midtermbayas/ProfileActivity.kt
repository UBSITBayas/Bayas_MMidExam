package edu.mobcom.midtermbayas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val ID = intent!!.getStringExtra("ID")
        val FirstName = intent!!.getStringExtra("FirstN")
        val LastName = intent!!.getStringExtra("LastN")
        val EmailAddresss = intent!!.getStringExtra("EmailA")
        val Password = intent!!.getStringExtra("Pass")
        val ConfirmPassword = intent!!.getStringExtra("ConP")
        val orderDetailsTV= findViewById<TextView>(R.id.Summary)
        val orderDetails= findViewById<EditText>(R.id.Summary)
        val logoutBtn: Button = findViewById(R.id.btnLogoutfromprofiletologin)


        val details: String = "Id Number:"+": "+ID+"\n"+"Complete Name"+": "+FirstName+"\n"+"Customer Number"+": "+LastName+"\n"+"Customer Mail"+": "+EmailAddresss+"\n"+"Selected Food"+": "+Password+"\n"+"Selected Beverage"+": "+ConfirmPassword




        orderDetails.setText(details)
        orderDetailsTV.text=details
        logoutBtn.setOnClickListener {
            val iBack = Intent(this@ProfileActivity, LoginActivity::class.java)
            startActivity(iBack)
        }

    }
}