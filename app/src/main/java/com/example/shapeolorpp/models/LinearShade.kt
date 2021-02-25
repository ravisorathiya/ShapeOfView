package com.example.shapeolorpp.models

import android.graphics.Shader
import android.graphics.drawable.GradientDrawable

data class LinearShade(
    val fontShader: Shader?,     // for font shader effect
    val linearColor: GradientDrawable?,      // linear color
    val circleColor: Int?     // for circle imageView set color

)