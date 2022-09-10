package com.example.adminapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.core.view.isNotEmpty
import com.example.adminapp.databinding.ActivityAddStudentBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_add_student.*

class AddStudent : AppCompatActivity() {
    lateinit var binding: ActivityAddStudentBinding
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {

//    var SName = binding.regName.text.toString()
//    val SEmail = binding.regName.text.toString()
//    val SRollNo = binding.regName.text.toString().toInt()
//    val SContactNo = binding.regName.text.toString().toInt()
//    val SParentContactNo = binding.regName.text.toString().toInt()
//    val SDepartment = binding.regName.text.toString()
//    val SRoomNo = binding.regName.text.toString()
//    val SPermanentAddress = binding.regName.text.toString()
//    val SCourse = binding.regCourse.getCheckedRadioButtonId()


        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonRegister.setOnClickListener(View.OnClickListener {
//            if (TextUtils.isEmpty(SName) || TextUtils.isEmpty(SEmail) || TextUtils.isEmpty(SRollNo.toString()) ||
//                TextUtils.isEmpty(SContactNo.toString()) || TextUtils.isEmpty(SParentContactNo.toString())
//            ) {
//                Toast.makeText(this, "All Fields are Required", Toast.LENGTH_SHORT).show();
//                regName.setError("Name is Required.")
//                regEmail.setError("Email is Required.")
//                regRollNo.setError("Roll Number is Required.")
//                regContactNo.setError("Contact Number is Required.")
//                regParentContactNo.setError("Parent Contact Number is Required.")
//            } else {
//                if (SContactNo.toString().length != 10) {
//                    regContactNo.setError("Enter a valid number.");
//                    Toast.makeText(this, "Contact number not correct!", Toast.LENGTH_LONG).show();
//                }
//                else if (SParentContactNo.toString().length != 10) {
//                    regContactNo.setError("Enter a valid number.");
//                    Toast.makeText(this, "Contact number not correct!", Toast.LENGTH_LONG).show();
//                }
//                else
            if (binding.regName.text.isNotEmpty() && binding.regEmail.text.isNotEmpty() &&
                binding.regRollNo.text.isNotEmpty())
//                && binding.regContactNo.text.isNotEmpty() &&
//                binding.regParentContactNo.text.isNotEmpty())
                {
                    storeNewUsersData()
                }
//            }
        })
}

    private fun storeNewUsersData() {
        val student = hashMapOf(
            "Room No" to binding.regRoomNo.text.toString(),
            "Permanent Address" to binding.regPermanentAddress.text.toString(),
            "Parent Contact No" to binding.regParentContactNo.text.toString(),
            "Contact No" to binding.regContactNo.text.toString(),
            "Roll No" to binding.regRollNo.text.toString().toInt(),
            "Department" to binding.regDepartment.text.toString(),
            "Email" to binding.regEmail.text.toString(),
            "Student Name" to binding.regName.text.toString()

        )
        db.collection("Students")
            .add(student)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(applicationContext,"Student Registered with ID: ${documentReference.id}",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            }
            .addOnFailureListener { e ->
                Toast.makeText(applicationContext,"Error: "+e.toString(),Toast.LENGTH_SHORT).show()
            }
    }

}
