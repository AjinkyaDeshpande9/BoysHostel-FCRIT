package com.example.boyshostelfcrit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.boyshostelfcrit.databinding.FragmentProfileBinding
import com.example.boyshostelfcrit.profile.AcademicDetails
import com.example.boyshostelfcrit.profile.LeaveLogs
import com.example.boyshostelfcrit.profile.PersonalDetails
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):
        View? {

        val bind = FragmentProfileBinding.inflate(layoutInflater)
        val personalDetails = PersonalDetails()
        val academicDetails = AcademicDetails()
        val leaveLogs = LeaveLogs()

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