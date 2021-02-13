package com.example.shapeolorpp.utills

import android.widget.SeekBar


inline fun SeekBar.onSeekerChange(crossinline  listener:(Float)->Unit) {

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
