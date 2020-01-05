package com.example.mymobileass.ui.quiz


import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.example.mymobileass.R
import com.example.mymobileass.databinding.FragmentQuizBinding

/**
 * A simple [Fragment] subclass.
 */
class Quiz : Fragment() {
    data class Question(
        val questPic: Drawable?,
        val quest: String,
        val answ: List<String>
    )
    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)
    private val questList: MutableList<Question> = mutableListOf(
        Question(questPic = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_aware_ribbon, null),
            quest = "What is Android Jetpack?",
            answ = listOf("All of these", "Tools", "Documentation", "Libraries")),
        Question(questPic = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_aware_ribbon, null),
            quest = "What is the base class for layouts?",
            answ = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")),
        Question(questPic = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_aware_ribbon, null),
            quest = "What layout do you use for complex screens?",
            answ = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")),
        Question(questPic = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_aware_ribbon, null),
            quest = "What do you use to push structured data into a layout?",
            answ = listOf("Data binding", "Data pushing", "Set text", "An OnClick method")),
        Question(questPic = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_aware_ribbon, null),
            quest = "What method do you use to inflate layouts in fragments?",
            answ = listOf("onCreateView()", "onActivityCreated()", "onCreateLayout()", "onInflateLayout()")),
        Question(questPic = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_aware_ribbon, null),
            quest = "What's the build system for Android?",
            answ = listOf("Gradle", "Graddle", "Grodle", "Groyle")),
        Question(questPic = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_aware_ribbon, null),
            quest = "Which class do you use to create a vector drawable?",
            answ = listOf("VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")),
        Question(questPic = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_aware_ribbon, null),
            quest = "Which one of these is an Android navigation component?",
            answ = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")),
        Question(questPic = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_aware_ribbon, null),
            quest = "Which XML element lets you register an activity with the launcher activity?",
            answ = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")),
        Question(questPic = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_aware_ribbon, null),
            quest = "What do you use to mark a layout for data binding?",
            answ = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"))
    )



    lateinit var currentQuestion: Question
    lateinit var answ: MutableList<String>
    private var selectedAnswer = 0
    private var questionIndex = 0
    private val numQuestions = Math.min((questList.size + 1) / 2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater, R.layout.fragment_quiz, container, false)

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.quiz = this

        binding.btnAnsw1.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){
            view: View ->
            selectedAnswer = 1
        }

        // Set the onClickListener for the submitButton
        binding.btnConfirm.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.radGrpAnsw.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.radAnsw2 -> answerIndex = 1
                    R.id.radAnsw3 -> answerIndex = 2
                    R.id.radAnsw4 -> answerIndex = 3
                }
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                if (answ[answerIndex] == currentQuestion.answ[0]) {
                    questionIndex++
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questList[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        // We've won!  Navigate to the gameWonFragment.
                        view.findNavController()
                            .navigate(R.id.action_nav_quiz_to_nav_home)
                    }
                } else {
                    // Game over! A wrong answer sends us to the gameOverFragment.
                    view.findNavController().
                        navigate(R.id.action_nav_quiz_to_nav_home)

                }
            }
        }
        return binding.root
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }
    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questList.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questList[questionIndex]
        // randomize the answers into a copy of the array
        answ = currentQuestion.answ.toMutableList()
        // and shuffle them
        answ.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_quiz, questionIndex + 1, numQuestions)
    }
}
