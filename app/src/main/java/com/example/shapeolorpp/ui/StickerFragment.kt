package com.example.shapeolorpp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shapeolorpp.MainActivity
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.StickerAdapter
import com.example.shapeolorpp.databinding.FragmentStickerBinding
import com.example.shapeolorpp.models.StickerData
import com.example.shapeolorpp.utills.CanvasImages
import com.example.shapeolorpp.utills.Constanse
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext


private const val TAG = "StickerFragment"

class StickerFragment : BottomSheetDialogFragment(), StickerAdapter.ImageTouchListner {

    private lateinit var binding: FragmentStickerBinding

    private lateinit var listSticker: ArrayList<StickerData>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sticker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStickerBinding.bind(view)

        val stickerAdapter = StickerAdapter(this)

        listSticker = CanvasImages.imageCanvas()

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            withContext(IO) {
                stickerAdapter.submitList(listSticker)
            }
            binding.rvSticker.apply {
                layoutManager = GridLayoutManager(context, 3)

                setHasFixedSize(true)
                adapter = stickerAdapter
            }
        }


    }

    override fun onImageClick(stickerItem: StickerData) {
        val intent = Intent(context, MainActivity::class.java)
        val bundle = Bundle()

        stickerItem.sticker?.let { bundle.putInt(Constanse.STICKER_KEY, stickerItem.sticker) }

        intent.putExtras(bundle)
        findNavController().popBackStack()
        startActivity(intent)
        activity?.finish()

    }


}

