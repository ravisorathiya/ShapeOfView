package com.example.shapeolorpp.utills

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.SeekBar
import android.widget.Toast
import com.github.siyamed.shapeimageview.RoundedImageView
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


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


fun openGallery(context: Activity) {
    val intent = Intent(Intent.ACTION_PICK)
    intent.type = "image/*"
    context.startActivityForResult(intent, Constanse.IMAGE_CODE)


}

fun resultImage(context: Context, imageURI: Uri, roundedImageView: RoundedImageView) {

    try {
        imageURI.let {
            if (Build.VERSION.SDK_INT < 28) {
                val bitmap = MediaStore.Images.Media.getBitmap(
                    context.contentResolver,
                    imageURI
                )
                roundedImageView.setImageBitmap(bitmap)
            } else {
                val source =
                    ImageDecoder.createSource(context.contentResolver, imageURI)
                val bitmap = ImageDecoder.decodeBitmap(source)
                roundedImageView.setImageBitmap(bitmap)

            }
        }

    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun getBitmapFromView(context:Context , bmp: Bitmap?): Uri? {
    var bmpUri: Uri? = null
    try {
        val file = File(context.externalCacheDir, System.currentTimeMillis().toString() + ".jpg")

        val out = FileOutputStream(file)
        bmp?.compress(Bitmap.CompressFormat.JPEG, 90, out)
        out.close()
        bmpUri = Uri.fromFile(file)

    } catch (e: IOException) {
        e.printStackTrace()
    }
    return bmpUri
}






