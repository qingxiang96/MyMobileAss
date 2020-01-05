package com.example.mymobileass.ui.quiz


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.example.mymobileass.R
import com.example.mymobileass.databinding.FragmentQuizBinding
import kotlinx.android.synthetic.main.fragment_quiz.*

/**
 * A simple [Fragment] subclass.
 */
class Quiz : Fragment() {

    data class Question(
        val questGiven: String,
        val extraInfo: String,
        val answList: List<String>
    )

    private val questList: MutableList<Question> = mutableListOf(
//        questPic = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_aware_ribbon, null),
        Question(questGiven = "How long does a Styrofoam cup roughly take to decompose?",
            extraInfo ="It only takes an orange peel six months to decompose",
            answList = listOf("400 years", "10 years", "6 months", "150 years")),
        Question(questGiven = "Country that consumes the most energy?",
            extraInfo ="The U.S. uses about 5% more energy than the world's second-largest energy consumer, China",
            answList = listOf("United States", "India", "China", "Canada")),
        Question(questGiven = "The Earth’s water only consist of how many percent that are usable for humans?",
            extraInfo ="Only about one-third of 1% of all water on Earth is available for human use.",
            answList = listOf("Less than 1", "97", "23", "6")),
        Question(questGiven = "Which waste litters our oceans the most?",
            extraInfo ="International Coastal Cleanup volunteers removed nearly 2 million cigarettes & cigarette filters in their most recent effort to clear litter from the world's oceans.",
            answList = listOf("Cigarettes", "Plastic bottles", "Bags", "Food containers")),
        Question(questGiven = "According to the World Health Organization, which city is the most polluted in the world?",
            extraInfo ="Mexico City has held the dubious distinction for at least four years in a row.",
            answList = listOf("Mexico City Mexico", "Los Angeles California", "New Dehli India", "Shanghai China")),
        Question(questGiven = "Which sources of energy is NOT renewable?",
            extraInfo ="Petroleum is a fossil fuel. Coal and natural gas are other examples of fossil fuels.",
            answList = listOf("Petroleum", "Solar power", "Hydropower", "Biomass")),
        Question(questGiven = "Which country produces the most energy in the world?",
            extraInfo ="China produces the most, about 79.1 quadrillion Btu of energy a year",
            answList = listOf("China", "Russia", "United States", "Iraq")),
        Question(questGiven = "What is the leading source of energy in the United States?",
            extraInfo ="Oil provides the U.S. with about 40% of its energy.",
            answList = listOf("Oil", "Coal", "Nuclear power", "Natural gas")),
        Question(questGiven = "Does washing a full load of dishes by hand or in the dishwasher uses less water?",
            extraInfo ="The latest hand washing dishes can use up to 50 percent more water than a water-saving, energy-efficient dishwasher.",
            answList = listOf("Dishwasher", "By hand", "-", "-")),
        Question(questGiven = "Is paper or plastic type of supermarket bag more eco friendly?",
            extraInfo ="Manufacturing and disposing of both paper & plastic bags harm the environment. Bring your own reusable bags instead.",
            answList = listOf("None of the above", "Paper", "Either is fine", "Plastic")),
        Question(questGiven = "Appliances do not use any electricity when they are turned off.",
            extraInfo ="Many appliances continue to use energy for features like clocks and remote control sensors even when they're turned off.",
            answList = listOf("False", "True", "-", "-")),
        Question(questGiven = "Hybrid cars are slower and less safe than conventional cars.",
            extraInfo ="Hybrid cars perform on par with or better than conventional car in driveability and safety testing.",
            answList = listOf("False ", "True", "-", "-")),
        Question(questGiven = "Approximately how much of global electricity produced are from renewable sources?",
            extraInfo ="Only about 10% of global energy comes from renewables. The remaining 92% comes from nonrenewable like oil, coal and natural gas.",
            answList = listOf("10%", "5%", "30%", "1%")),
        Question(questGiven = "About how much money you can save by using a single incandescent light bulb instead of a compact fluorescent light (CFL)?",
            extraInfo ="According to the US Environmental Protection Agency, CFLs use 2/3 less energy than standard incandescent bulbs and last up to 10x longer.",
            answList = listOf("$30", "$5", "$125", "$50")),
        Question(questGiven = "Is it better to leave the light on than to turn it on and off several times a day?",
            extraInfo ="It is always better to turn lights off when not in use. And there is no additional energy requirement for starting a CFL bulb.",
            answList = listOf("No", "Yes", "-", "-")),
        Question(questGiven = "You conserve more fuel by driving fast and reach your destination sooner than you following the speed limit.",
            extraInfo ="The EPA estimates you save about 15% on fuel by driving 55 miles (88 km) rather than 65 miles (105 km) per hour.",
            answList = listOf("True", "False", "-", "-")),
        Question(questGiven = "When is earth’s warmest year on record?",
            extraInfo ="2016 was the hottest — the third consecutive year a new global annual temperature record has been set.",
            answList = listOf("2016", "2008", "2012", "2014")),
        Question(questGiven = "What is the ozone layer?",
            extraInfo ="The ozone layer is the second layer of the earth’s stratosphere that protects us from the sun’s ultraviolet radiation.",
            answList = listOf("The layer of protective gases that shields the earth from harmful radiation."
                , "The layer of pollution that’s causing heat to build in the atmosphere."
                , "The layer of gases surrounding the earth that absorbs pollutants in the atmosphere."
                , "None of the above.")),
        Question(questGiven = "Scientists are predicting the sea level will rise by how much by the end of this century?",
            extraInfo ="Two feet is a best-case scenario. Five million Americans are estimated to live in homes at less than 4 feet above high tide.",
            answList = listOf("2-6 feet", "6 inches-2 feet", "1-3 feet", "4-8 inches")),
        Question(questGiven = "How much of our air pollution comes from motor vehicles, like cars and trucks?",
            extraInfo ="",
            answList = listOf("50%", "20%", "30%", "40%")),
        Question(questGiven = "While natural greenhouse gases create the greenhouse effect that keeps the Earth warm enough to support life, ___ is the main source of excess greenhouse gases in the atmosphere.",
            extraInfo ="",
            answList = listOf("Human use of fossil fuels", "Population growth", "Factory farming", "Deforestation")),
        Question(questGiven = "1 kilogram of consumer goods created by, manufacturers may lead to ___ kilograms of waste.",
            extraInfo ="",
            answList = listOf("5", "3", "1", "7")),
        Question(questGiven = "Consequence of global warming.",
            extraInfo ="",
            answList = listOf("All", "Influence the length of seasons.", "Cause coastal flooding.", "Lead to more frequent and severe storms.")),
        Question(questGiven = "Rainforests used to cover 14% of the earth's land surface, but now they cover ___",
            extraInfo ="",
            answList = listOf("6%", "8%", "10%", "12%")),
        Question(questGiven = "Global warming is caused by",
            extraInfo ="",
            answList = listOf("Both by human and natural factors.", "Only by natural factors.", "Mainly by natural factors.", "Only by human activity.")),
        Question(questGiven = "Every 1 kilogram of paper recycled, we can save how many trees?",
            extraInfo ="",
            answList = listOf("17trees ", "32trees ", "50trees ", " 68trees ")),
        Question(questGiven = "How long does it take for carbon dioxide (CO2) in the atmosphere to disperse?",
            extraInfo ="",
            answList = listOf("100 years", "500 years", "50 years", "10 years")),
        Question(questGiven = "How many species of plant, animal and insect are being lost every day due to rainforest  deforestation?",
            extraInfo ="",
            answList = listOf("137 ", "100", "168", "More than 200"))
    )

    private val maxQuest = 6
    private var questNO = 0
    lateinit var currentQuest: Question
    lateinit var currentAnswList: MutableList<String>
    private var selectedAnswer = -1
    private var correctAnswer = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater, R.layout.fragment_quiz, container, false
        )
        randomizeQuestions()
        binding.quiz = this

        binding.btnAnsw1.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){view: View ->
            selectedAnswer = 0
            updateBtn(0)
        }
        binding.btnAnsw2.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){view: View ->
            selectedAnswer = 1
            updateBtn(1)
        }
        binding.btnAnsw3.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){view: View ->
            selectedAnswer = 2
            updateBtn(2)
        }
        binding.btnAnsw4.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){view: View ->
            selectedAnswer = 3
            updateBtn(3)
        }

        binding.btnConfirm.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        {view: View ->
            if(btnConfirm.text == ">> Next >>" || btnConfirm.text == "Result"){
                selectedAnswer = -1
                if(questNO < maxQuest){
                    btnAnsw1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    btnAnsw2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    btnAnsw3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    btnAnsw4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    txtInfo.setText("")
                    btnConfirm.setText("Confirm")
                    currentQuest = questList[questNO]
                    setQuestion()
                    binding.invalidateAll()
                }
                else{
                    view.findNavController().navigate(R.id.action_nav_quiz_to_quiz_end)
                }
            }
            else if(btnConfirm.text == "Confirm" && selectedAnswer >= 0){
                if(currentAnswList[selectedAnswer] == currentQuest.answList[0]){
                    questNO++
                    revealAnsw()
                    txtInfo.setText(currentQuest.extraInfo)
                    QuizVar.incYourScore(1)
                    btnConfirm.setText(">> Next >>")
                }
                else{
                    questNO++
                    revealAnsw()
                    txtInfo.setText(currentQuest.extraInfo)
                    if(questNO < maxQuest){
                        btnConfirm.setText(">> Next >>")
                    }
                    else{btnConfirm.setText("Result")
                    }
                }
            }
        }
        return binding.root

//        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    private fun revealAnsw(){
        getAnswer()
        when(correctAnswer){
            0 -> {btnAnsw1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_right))
                btnAnsw2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wrong))
                btnAnsw3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wrong))
                btnAnsw4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wrong))
            }
            1 -> {btnAnsw1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wrong))
                btnAnsw2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_right))
                btnAnsw3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wrong))
                btnAnsw4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wrong))
            }
            2 -> {btnAnsw1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wrong))
                btnAnsw2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wrong))
                btnAnsw3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_right))
                btnAnsw4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wrong))
            }
            3 -> {btnAnsw1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wrong))
                btnAnsw2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wrong))
                btnAnsw3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wrong))
                btnAnsw4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_right))
            }
        }
    }

    private fun getAnswer(){
        if(btnAnsw1.text == currentQuest.answList[0]){
            correctAnswer = 0
        }
        else if(btnAnsw2.text == currentQuest.answList[0]){
            correctAnswer = 1
        }
        else if(btnAnsw3.text == currentQuest.answList[0]){
            correctAnswer = 2
        }
        else if(btnAnsw4.text == currentQuest.answList[0]){
            correctAnswer = 3
        }
    }

    private fun randomizeQuestions(){
        questList.shuffle()
        questNO = 0
        setQuestion()
    }

    private fun updateBtn(i: Int){
        if(btnConfirm.text == ">> Next >>" || btnConfirm.text == "Result")
        {}
        else{
            when(i){
                0 -> {
                    btnAnsw1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_select))
                    btnAnsw2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    btnAnsw3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    btnAnsw4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                }
                1 -> {
                    btnAnsw1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    btnAnsw2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_select))
                    btnAnsw3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    btnAnsw4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                }
                2 -> {
                    btnAnsw1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    btnAnsw2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    btnAnsw3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_select))
                    btnAnsw4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                }
                3 -> {
                    btnAnsw1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    btnAnsw2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    btnAnsw3.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_wait))
                    btnAnsw4.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.quiz_btn_select))
                }
            }
        }
    }

    private fun setQuestion(){
        currentQuest = questList[questNO]
        currentAnswList = currentQuest.answList.toMutableList()
        currentAnswList.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_quiz, questNO + 1, maxQuest)
    }

}

