package com.example.boyshostelfcrit.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.boyshostelfcrit.R
import com.example.boyshostelfcrit.SuccessFragment
import com.example.boyshostelfcrit.databinding.FragmentFormLongConfirmBinding
import com.example.boyshostelfcrit.databinding.FragmentFormShortConfirmBinding

class FormShortConfirm : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentFormShortConfirmBinding.inflate(layoutInflater)
        bind.shortFormConfirmBack.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.mainFragmentContainer, FormShort(), FormShort::class.java.simpleName)
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
            FormShortConfirm().apply {
                arguments = Bundle().apply {

                }
            }
    }
}