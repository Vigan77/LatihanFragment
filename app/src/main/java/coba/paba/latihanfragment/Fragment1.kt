package coba.paba.latihanfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import coba.paba.latihanfragment.MainActivity
import coba.paba.latihanfragment.R
import kotlin.random.Random

class Fragment1 : Fragment() {

    private var score: Int = 50
    private lateinit var scoreTextView: TextView
    private lateinit var guessTextView: TextView
    private lateinit var numberButton1: Button
    private lateinit var numberButton2: Button
    private lateinit var giveUpButton: Button

    private var currentGuessPair: Pair<Int, Int>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        scoreTextView = view.findViewById(R.id.score_text_view)
        guessTextView = view.findViewById(R.id.guess_text_view)
        numberButton1 = view.findViewById(R.id.number_button_1)
        numberButton2 = view.findViewById(R.id.number_button_2)
        giveUpButton = view.findViewById(R.id.give_up_button)

        updateScore()
        generateRandomNumbers()

        numberButton1.setOnClickListener { checkGuess(numberButton1.text.toString().toInt()) }
        numberButton2.setOnClickListener { checkGuess(numberButton2.text.toString().toInt()) }

        giveUpButton.setOnClickListener {
            (activity as MainActivity).finalScore = score
            (activity as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment2())
                .commit()
        }

        return view
    }

    private fun generateRandomNumbers() {
        val maxNumber = (activity as MainActivity).maxRandomNumber
        val randomNumbers = List(2) { Random.nextInt(1, maxNumber + 1) }
        currentGuessPair = Pair(randomNumbers[0], randomNumbers[1])

        guessTextView.text = "Tebak apakah kedua angka sama?"
        numberButton1.text = randomNumbers[0].toString()
        numberButton2.text = randomNumbers[1].toString()
    }

    private fun checkGuess(selectedNumber: Int) {
        val (first, second) = currentGuessPair ?: return
        if (first == second) {
            score += 10
            guessTextView.text = "Benar! +10"
        } else {
            score -= 5
            guessTextView.text = "Salah! -5"
        }
        updateScore()
        generateRandomNumbers()
    }

    private fun updateScore() {
        scoreTextView.text = "Skor: $score"
    }
}