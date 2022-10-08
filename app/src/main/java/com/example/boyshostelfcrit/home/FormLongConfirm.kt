package com.example.boyshostelfcrit.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.boyshostelfcrit.HomeFragment
import com.example.boyshostelfcrit.R
import com.example.boyshostelfcrit.SuccessFragment
import com.example.boyshostelfcrit.databinding.FragmentFormLongBinding
import com.example.boyshostelfcrit.databinding.FragmentFormLongConfirmBinding

class FormLongConfirm : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentFormLongConfirmBinding.inflate(layoutInflater)
        bind.longFormConfirmBack.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.mainFragmentContainer, FormLong(), FormLong::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }


        }
        bind.buttonSubmit.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.mainFragmentContainer, SuccessFragment(), SuccessFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }

        }
        return bind.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FormLongConfirm().apply {
                arguments = Bundle().apply {

                }
            }
    }
}