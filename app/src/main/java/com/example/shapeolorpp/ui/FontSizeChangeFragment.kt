package com.example.shapeolorpp.ui

import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import com.example.shapeolorpp.R
import com.example.shapeolorpp.utills.onSeekerChange


class FontSizeChangeFragment : Fragment(R.layout.fragment_font_size) {

    private val TAG = "FontSizeChangeFragment"
    lateinit var textWishView: TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val seekBarHorizontal = view.findViewById<SeekBar>(R.id.seekBarHorizontal)
        val seekBarVerticle = view.findViewById<SeekBar>(R.id.seekBarVerticle)

        textWishView = requireActivity().findViewById(R.id.text_wish)


        seekBarHorizontal.onSeekerChange {
            textWishView.text
//            textWishView.textSize = it
            textWishView.setPadding(0,16,0,0)
            textWishView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,it)
//            textWishView.setAutoSizeTextTypeUniformWithConfiguration(
//                1, 17, 1, TypedValue.COMPLEX_UNIT_DIP);
        }

        seekBarVerticle.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })


    }


}