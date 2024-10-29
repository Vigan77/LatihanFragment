package coba.paba.latihanfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import coba.paba.latihanfragment.MainActivity
import coba.paba.latihanfragment.R
class Fragment3 : Fragment() {

    private lateinit var maxNumberEditText: EditText
    private lateinit var setMaxNumberButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_3, container, false)

        maxNumberEditText = view.findViewById(R.id.max_number_edit_text)
        setMaxNumberButton = view.findViewById(R.id.set_max_number_button)

        setMaxNumberButton.setOnClickListener {
            val maxNumber = maxNumberEditText.text.toString().toIntOrNull() ?: return@setOnClickListener
            (activity as MainActivity).maxRandomNumber = maxNumber
        }

        return view
    }
}