package edu.mobcom.midtermbayas

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val rusername = intent!!.getStringExtra("username")
        val sendMsg = findViewById<Button>(R.id.btnSendMsg)
        var iSend: Intent

        val details: String = "Welcome " +rusername

        Toast.makeText(this, details, Toast.LENGTH_LONG).show()

        val reci=findViewById<EditText>(R.id.inRecipient)
        val subj=findViewById<EditText>(R.id.inSubject)
        val msg=findViewById<EditText>(R.id.inMessage)
        val errMsg="No message Found"
        val logoutBtn: Button = findViewById(R.id.btnLogoutfromMessage)



        sendMsg?.setOnClickListener{
            iSend=Intent(Intent.ACTION_SENDTO).apply{
                data= Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL,reci.toString())
                putExtra(Intent.EXTRA_SUBJECT, subj.toString());
                putExtra(Intent.EXTRA_TEXT, msg.toString())
            }
            try{
                startActivity(iSend)
                Toast.makeText(this, "Email Message sent!", Toast.LENGTH_LONG).show()
            } catch (e: ActivityNotFoundException){
                Toast.makeText(this, "content error", Toast.LENGTH_LONG).show()
            }
        }

        logoutBtn.setOnClickListener {
            val iBack = Intent(this@MessageActivity, LoginActivity::class.java)
            startActivity(iBack)
        }
    }
}