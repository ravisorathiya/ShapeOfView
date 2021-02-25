package com.example.shapeolorpp.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
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
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext


private const val TAG = "StickerFragment"

class StickerFragment : BottomSheetDialogFragment(), StickerAdapter.ImageTouchListner {

    private lateinit var listSticker: ArrayList<StickerData>

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
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

    private lateinit var binding: FragmentStickerBinding

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

//        val bitmap = stickerItem.sticker?.let { BitmapFactory.decodeResource(resources, it) }
//        val baos = ByteArrayOutputStream()
//        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, baos);
//        val b = baos.toByteArray()
//        stickerItem.sticker?.let { bundle.putSerializable(Constanse.STICKER_KEY, b) }
//

        stickerItem.sticker?.let { bundle.putInt(Constanse.STICKER_KEY, stickerItem.sticker) }

        intent.putExtras(bundle)
        findNavController().popBackStack()
        startActivity(intent)
        activity?.finish()

    }


}

