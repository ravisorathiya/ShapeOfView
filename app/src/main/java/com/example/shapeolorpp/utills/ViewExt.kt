package com.example.shapeolorpp.utills

import android.content.Context
import android.widget.SeekBar
import android.widget.Toast


inline fun SeekBar.onSeekerChange(crossinline listener: (Float) -> Unit) {

    this.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            listener(progress.toFloat())
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {

        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
        }
    })

}

fun Context.toast(message: Any) =
    Toast.makeText(applicationContext, message.toString(), Toast.LENGTH_SHORT).show()



/*override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
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
    layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
    bottomSheet.layoutParams = layoutParams
}*/



/*        val bm = imageSticker?.let { BitmapFactory.decodeResource(resources, it) }
        imageSticker.let { binding.stickerImage.setImageBitmap(bm) }*/


// bitmap
/*        val bitmap = imageSticker?.let { BitmapFactory.decodeResource(resources, it) }
        binding.stickerImage.setImageBitmap(bitmap)

        val drawable = ContextCompat.getDrawable(this, R.drawable.ic_edit)
        drawable?.let{
           binding.canvasEditor.addDrawableSticker(drawable)
        }*/



//        val heartIcon = BitmapStickerIcon(
//            ContextCompat.getDrawable(this, R.drawable.ic_delete),
//            BitmapStickerIcon.LEFT_BOTTOM
//        )
//        heartIcon.iconEvent = HelloIconEvent()



//        binding.stickerImage.visibility = View.VISIBLE
//        imageSticker?.let { binding.stickerImage.setImageResource(it) }






