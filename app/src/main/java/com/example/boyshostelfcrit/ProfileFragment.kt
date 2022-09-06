package com.example.boyshostelfcrit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.boyshostelfcrit.databinding.FragmentProfileBinding
import com.example.boyshostelfcrit.model.User
import com.example.boyshostelfcrit.profile.AcademicDetails
import com.example.boyshostelfcrit.profile.LeaveLogs
import com.example.boyshostelfcrit.profile.PersonalDetails
import com.google.common.primitives.Bytes
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.*
import java.lang.StringBuilder


class ProfileFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):
        View? {
        val db = FirebaseFirestore.getInstance()
        val bind = FragmentProfileBinding.inflate(layoutInflater)
        val personalDetails = PersonalDetails()
        val academicDetails = AcademicDetails()
        val leaveLogs = LeaveLogs()
        // For Profile Data
        val docRef = db.collection("Users").document("pnAZSjD3i26EIt1AmOkW")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("exist", "DocumentSnapshot Data: ${document.id}")
                    profilefrag_name.text = document.getString(profilefrag_name.toString())
                    profilefrag_dept.text = document.getString(profilefrag_dept.toString())
                }else
                    Log.d("notexists","No Such Document")
            }
            .addOnFailureListener { exception ->
                Log.w("errordb", "get Failed With", exception)
            }

        bind.btnPersonalDetails.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.mainFragmentContainer, personalDetails, PersonalDetails ::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
        bind.btnAcademicDetails.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.mainFragmentContainer, academicDetails, AcademicDetails ::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
        bind.btnLeaveRegistry.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.mainFragmentContainer, leaveLogs, LeaveLogs ::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
        return bind.root
    }

    companion object {
        @JvmStatic fun newInstance() =
            ProfileFragment().apply {
                arguments = Bundle().apply {}
            }
    }

}