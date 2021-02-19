package com.example.shapeolorpp.ui.fragments.text

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.shapeolorpp.R
import com.example.shapeolorpp.databinding.FragmentFontspacerBinding
import com.example.shapeolorpp.utills.onSeekerChange


class FontSpacerFragment : Fragment(R.layout.fragment_fontspacer) {

    private lateinit var binding: FragmentFontspacerBinding
    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var textViewWish: TextView

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFontspacerBinding.bind(view)
        constraintLayout = requireActivity().findViewById(R.id.linearLayout3)
        textViewWish = requireActivity().findViewById(R.id.text_wish)

        binding.leftToRight.onSeekerChange {

            val spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            textViewWish.measure(spec, spec)
            val quotaWidth: Int = textViewWish.measuredWidth

            val spec2 = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            textViewWish.measure(spec2, spec2)
            val sbWidth: Int = binding.leftToRight.measuredWidth
            val params = textViewWish.layoutParams as ConstraintLayout.LayoutParams
            params.leftMargin = it.toInt() * 5
//                ((it / binding.seekHori.max * sbWidth - quotaWidth.toDouble() * it / binding.seekHori.max).toInt())
            textViewWish.layoutParams = params


        }


        binding.rightToLeft.onSeekerChange {
            val spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            textViewWish.measure(spec, spec)
            val quotaWidth: Int = textViewWish.measuredWidth

            val spec2 = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            textViewWish.measure(spec2, spec2)
            val sbWidth: Int = binding.leftToRight.measuredWidth
            val params = textViewWish.layoutParams as ConstraintLayout.LayoutParams
            params.rightMargin = it.toInt() * 5
//                ((it / binding.seekHori.max * sbWidth - quotaWidth.toDouble() * it / binding.seekHori.max).toInt())
            textViewWish.layoutParams = params


        }

    }

}