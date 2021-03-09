package com.example.shapeolorpp.models

import android.graphics.SweepGradient
import android.graphics.drawable.GradientDrawable

data class Sweeper(
    val sweeperGradient: SweepGradient?,
    val sweeperDrawable: GradientDrawable?,
    val circleColor:Int?
)
