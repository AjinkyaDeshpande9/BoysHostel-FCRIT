package com.example.boyshostelfcrit

import android.animation.Animator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.boyshostelfcrit.databinding.ActivityLoginBinding.inflate
import com.example.boyshostelfcrit.databinding.FragmentFormLongBinding
import kotlinx.android.synthetic.main.fragment_success.*

class SuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(getActivity(),"Form Submitted Successfully!",Toast.LENGTH_SHORT).show()
            return inflater.inflate(R.layout.fragment_success, container, false)
        }

    companion object {
            @JvmStatic
            fun newInstance() =
                SuccessFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
        }
    }
