package com.example.boyshostelfcrit.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.boyshostelfcrit.HomeFragment
import com.example.boyshostelfcrit.R
import com.example.boyshostelfcrit.databinding.FragmentFormLongBinding

class FormShort : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val formshortconfirm = FormShortConfirm()
        val bind = FragmentFormLongBinding.inflate(layoutInflater)

        bind.buttonContinue.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.mainFragmentContainer,
                    formshortconfirm,
                    FormLongConfirm::class.java.simpleName
                )
                    .addToBackStack(null)
                    .commit()
            }

        }
        return bind.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FormShort().apply {
                arguments = Bundle().apply {

                }
            }
    }
}