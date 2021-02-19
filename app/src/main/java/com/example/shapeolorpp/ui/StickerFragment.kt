package com.example.shapeolorpp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shapeolorpp.R
import com.example.shapeolorpp.databinding.StickerFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class StickerFragment : BottomSheetDialogFragment() {

    private lateinit var binding : StickerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sticker_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = StickerFragmentBinding.bind(view)

    }

}