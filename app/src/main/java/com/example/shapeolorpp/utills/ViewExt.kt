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







