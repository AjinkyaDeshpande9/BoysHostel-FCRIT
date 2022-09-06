package com.example.boyshostelfcrit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val dbFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener{
            val email = getEmail.text.toString()
            val password = getPassword.text.toString()
            signIn(email, password)

        }
    }
    private fun signIn(email:String, password:String)
    {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            when{
                it.isSuccessful -> {
                    Toast.makeText(this,"User Login Successfully",Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else -> {
                    Toast.makeText(this, "User Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}