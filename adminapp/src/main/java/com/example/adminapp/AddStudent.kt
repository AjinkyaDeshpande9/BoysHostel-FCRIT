package com.example.adminapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isNotEmpty
import com.example.adminapp.databinding.ActivityAddStudentBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddStudent : AppCompatActivity() {
    lateinit var binding: ActivityAddStudentBinding
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.regSubmitbutton.setOnClickListener(View.OnClickListener {
           if(binding.regName.text.isNotEmpty() && binding.regDepartment.text.isNotEmpty() &&
               binding.regRollNo.text.isNotEmpty()) {

               val student = hashMapOf(
                   "Student Name" to binding.regName.text.toString(),
                   "Email" to binding.regEmail.text.toString(),
                   "Department" to binding.regDepartment.text.toString(),
                   "Roll No" to binding.regRollNo.text.toString().toInt()
               )
// Add a new document with a generated ID
               db.collection("Students")
                   .add(student)
                   .addOnSuccessListener { documentReference ->
                       Toast.makeText(applicationContext,"Student Registered with ID: ${documentReference.id}",Toast.LENGTH_SHORT).show()
                       startActivity(Intent(this, MainActivity::class.java))
                   }
                   .addOnFailureListener { e ->
                       Toast.makeText(applicationContext,"Error: "+e.toString(),Toast.LENGTH_SHORT).show()
                   }

           }else {
                Toast.makeText(applicationContext,"Please Insert Values",Toast.LENGTH_SHORT).show()
           }

        })
    }
}