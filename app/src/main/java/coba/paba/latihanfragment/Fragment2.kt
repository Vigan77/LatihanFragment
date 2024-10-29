package coba.paba.latihanfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import coba.paba.latihanfragment.MainActivity
import coba.paba.latihanfragment.R

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)

        val finalScoreTextView: TextView = view.findViewById(R.id.final_score_text_view)

        val finalScore = (activity as MainActivity).finalScore
        finalScoreTextView.text = "Nilai Akhir: $finalScore"

        return view
    }
}