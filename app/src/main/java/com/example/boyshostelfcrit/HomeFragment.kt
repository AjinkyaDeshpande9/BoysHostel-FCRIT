package com.example.boyshostelfcrit

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.boyshostelfcrit.databinding.FragmentHomeBinding
import com.example.boyshostelfcrit.databinding.FragmentProfileBinding
import com.example.boyshostelfcrit.home.Complains
import com.example.boyshostelfcrit.home.FormLong
import com.example.boyshostelfcrit.home.FormShort
import com.example.boyshostelfcrit.home.Mess
import com.example.boyshostelfcrit.profile.AcademicDetails
import com.example.boyshostelfcrit.profile.LeaveLogs
import com.example.boyshostelfcrit.profile.PersonalDetails
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val bind = FragmentHomeBinding.inflate(layoutInflater)
        val formShort = FormShort()
        val formLong = FormLong()
        val complains = Complains()
        val mess = Mess()

        bind.formShortDuration.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.mainFragmentContainer, formShort, FormShort ::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        bind.formLongDuration.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.mainFragmentContainer, formLong, FormLong ::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        bind.complains.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.mainFragmentContainer, complains, Complains ::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        bind.mess.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.mainFragmentContainer, mess, Mess ::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
        return bind.root
    }

    companion object {
        @JvmStatic fun newInstance() =
                HomeFragment().apply {
                    arguments = Bundle().apply {}
                }
    }


}