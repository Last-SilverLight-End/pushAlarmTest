package com.example.pushalarmtest2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.FirebaseExceptionMapper
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val resultTextView : TextView by lazy{
        findViewById(R.id.resultTextView)
    }

    private val firebaseToken: TextView by lazy{
        findViewById(R.id.firebaseTokenTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFirebase()
    }

    private fun initFirebase() {
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    firebaseToken.text = task.result
                }
            }
    }
}