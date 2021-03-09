package com.example.shapeolorpp.models

import android.net.Uri
import ja.burhanrashid52.photoeditor.PhotoEditor
import ja.burhanrashid52.photoeditor.PhotoFilter

data class Filter(
    val filter : PhotoFilter,
    val imageUri : Uri,
    val photoFilter: PhotoEditor
    )
