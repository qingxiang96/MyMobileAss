package com.example.mymobileass.ui.quiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.example.mymobileass.R
import com.example.mymobileass.databinding.FragmentQuizEndBinding

/**
 * A simple [Fragment] subclass.
 */
class QuizEnd : Fragment() {

    var endTitle = ""
    var result = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_quiz_end, container, false)
        val binding = DataBindingUtil.inflate<FragmentQuizEndBinding>(
            inflater, R.layout.fragment_quiz_end, container, false)
        binding.quizEnd = this
        if(QuizVar.getScore() <= 2){
            endTitle = "Poor Result,\nTry Again!"
        }else if(QuizVar.getScore() == 3 || QuizVar.getScore() == 4){
            endTitle = "Not Bad!"
        }else if(QuizVar.getScore() >= 5){
            endTitle = "Well Done!"
        }
        result = "You answered\n" + QuizVar.getScore() + " out of 6\ncorrectly."
        (activity as AppCompatActivity).supportActionBar?.title = "Your Score"
        QuizVar.setYourScore(0)
        binding.btnNewQuiz.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            view.findNavController()
                .navigate(R.id.action_nav_quiz_end_to_nav_quiz)
        }
        return binding.root
    }

}
