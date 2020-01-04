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

        binding.newsLogo.setOnClickListener{
            this.findNavController().navigate(R.id.action_nav_home_to_nav_news)
        }

        binding.coverageLogo.setOnClickListener{
            this.findNavController().navigate(R.id.action_nav_home_to_nav_coverage)
        }

        binding.organizationLogo.setOnClickListener{
            this.findNavController().navigate(R.id.action_nav_home_to_nav_org)
        }

        binding.quizLogo.setOnClickListener{
            this.findNavController().navigate(R.id.action_nav_home_to_nav_quiz)
        }

        binding.plantTreeLogo.setOnClickListener{
            this.findNavController().navigate(R.id.action_nav_home_to_nav_plant2)
        }

        binding.envAwareness.setOnClickListener{
            this.findNavController().navigate(R.id.action_nav_home_to_nav_awareness)
        }

        binding.txtNews.setOnClickListener{
            this.findNavController().navigate(R.id.action_nav_home_to_nav_news)
        }

        binding.txtCoverage.setOnClickListener{
            this.findNavController().navigate(R.id.action_nav_home_to_nav_coverage)
        }

        binding.txtOrganization.setOnClickListener{
            this.findNavController().navigate(R.id.action_nav_home_to_nav_org)
        }

        binding.txtQuiz.setOnClickListener{
            this.findNavController().navigate(R.id.action_nav_home_to_nav_quiz)
        }

        binding.txtPlanttree.setOnClickListener{
            this.findNavController().navigate(R.id.action_nav_home_to_nav_plant2)
        }

        return binding.root
    }


}
