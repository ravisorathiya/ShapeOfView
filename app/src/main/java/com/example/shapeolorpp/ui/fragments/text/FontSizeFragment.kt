package com.example.shapeolorpp.ui.fragments.text

import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.shapeolorpp.R
import com.example.shapeolorpp.utills.onSeekerChange


class FontSizeFragment : Fragment(R.layout.fragment_font_size) {

    private val TAG = "FontSizeChangeFragment"
    lateinit var textWishView: TextView

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val seekerFontSizing = view.findViewById<SeekBar>(R.id.seek_font_sizing)
        val seekerOpacity = view.findViewById<SeekBar>(R.id.seekbar_opacity)
        val seekerLetterSpacing = view.findViewById<SeekBar>(R.id.seekbar_letter_spacing)
        val seekerLineSpace = view.findViewById<SeekBar>(R.id.seekbar_line_spacing)

        textWishView = requireActivity().findViewById(R.id.text_wish)

        // change size of font
        seekerFontSizing.onSeekerChange {
            textWishView.setTextSize(
                TypedValue.COMPLEX_UNIT_PX, it

            )
        }

        // change opacity color of text
        seekerOpacity.onSeekerChange {
            val backgroundOpacity: Int = it.toInt() * 0x01000000
            textWishView.apply {
                setTextColor(backgroundOpacity + 0xffffff)
                setTextColor(backgroundOpacity + 0xffffff)
                setTextColor(backgroundOpacity + 0xffffff)
            }
        }

        // latter spacing
        seekerLetterSpacing.onSeekerChange {
            textWishView.letterSpacing = it / 100
        }

        // line spacing
        seekerLineSpace.onSeekerChange {
            textWishView.setLineSpacing(it / 50, it / 50)
        }
    }
}

