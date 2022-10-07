package com.example.boyshostelfcrit.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.boyshostelfcrit.HomeFragment
import com.example.boyshostelfcrit.R
import com.example.boyshostelfcrit.databinding.FragmentFormLongBinding
import com.example.boyshostelfcrit.databinding.FragmentProfileBinding
import com.example.boyshostelfcrit.profile.LeaveLogs
import com.example.boyshostelfcrit.profile.PersonalDetails
import kotlinx.android.synthetic.main.fragment_home.*

class FormLong : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val formlongconfirm = FormLongConfirm()
        val bind = FragmentFormLongBinding.inflate(layoutInflater)

        bind.buttonContinue.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.mainFragmentContainer,
                    formlongconfirm,
                    FormLongConfirm::class.java.simpleName
                )
                    .addToBackStack(null)
                    .commit()
            }
            bind.longFormBack.setOnClickListener {
                fragmentManager?.beginTransaction()?.apply {
                    replace(
                        R.id.mainFragmentContainer, HomeFragment(), HomeFragment::class.java.simpleName)
                        .addToBackStack(null)
                        .commit()
                }
            }

        }
        return bind.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FormLong().apply {
                arguments = Bundle().apply {

                }
            }
    }
}