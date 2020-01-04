package com.example.mymobileass.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController

import com.example.mymobileass.R
import com.example.mymobileass.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class Home : Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        val binding : FragmentHomeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home,container,false)

        binding.navAwareness.setOnClickListener{
            this.findNavController().navigate(R.id.action_nav_home_to_nav_awareness)
        }
        return binding.root
    }


}
