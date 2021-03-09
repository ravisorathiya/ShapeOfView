package com.example.shapeolorpp.utills

import android.net.Uri
import com.example.shapeolorpp.models.Filter
import ja.burhanrashid52.photoeditor.PhotoEditor
import ja.burhanrashid52.photoeditor.PhotoFilter

object Filters {


    fun filtersList(uri : Uri,photoEditor: PhotoEditor): List<Filter> {

        val data = listOf(
            Filter(PhotoFilter.CROSS_PROCESS,uri,photoEditor),
            Filter(PhotoFilter.TINT,uri,photoEditor),
            Filter(PhotoFilter.BLACK_WHITE,uri,photoEditor),
            Filter(PhotoFilter.CONTRAST,uri,photoEditor),
            Filter(PhotoFilter.SHARPEN,uri,photoEditor),
            Filter(PhotoFilter.BRIGHTNESS,uri,photoEditor),
            Filter(PhotoFilter.LOMISH,uri,photoEditor),
            Filter(PhotoFilter.TEMPERATURE,uri,photoEditor),
            Filter(PhotoFilter.SATURATE,uri,photoEditor)
        )

        return data
    }

}