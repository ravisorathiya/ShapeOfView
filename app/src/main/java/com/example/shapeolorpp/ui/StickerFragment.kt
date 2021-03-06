package com.example.shapeolorpp.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.StickerAdapter
import com.example.shapeolorpp.databinding.FragmentStickerBinding
import com.example.shapeolorpp.models.Sticker
import com.example.shapeolorpp.utills.CanvasImages
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext


private const val TAG = "StickerFragment"

class StickerFragment : BottomSheetDialogFragment(), StickerAdapter.ImageTouchListner {

    private lateinit var binding: FragmentStickerBinding
    private lateinit var listSticker: ArrayList<Sticker>
    private lateinit var dialog : BottomSheetDialog

    private  var sticker : setOnStickerListener? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            sticker  = activity as setOnStickerListener
        } catch (e: ClassCastException) {
            throw java.lang.ClassCastException(activity.toString())
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {

            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { it ->
                val behaviour = BottomSheetBehavior.from(it)
                setupFullHeight(it)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return dialog
    }

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

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

        val stickerAdapter = context?.let { StickerAdapter(it, this) }

        listSticker = CanvasImages.imageCanvas()

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            withContext(IO) {
                stickerAdapter?.submitList(listSticker)
            }

            binding.rvSticker.apply {
                layoutManager = GridLayoutManager(context, 3)
                stickerAdapter?.itemCount?.let { setItemViewCacheSize(it) }
                setHasFixedSize(true)
                adapter = stickerAdapter
            }
        }


    }

    override fun onImageClick(stickerItem: Sticker) {

        stickerItem.sticker?.let { sticker?.setSticker(it) }
        dialog.dismiss()
    }

    interface setOnStickerListener {
        fun setSticker(stickerRef : Int)
    }


}

