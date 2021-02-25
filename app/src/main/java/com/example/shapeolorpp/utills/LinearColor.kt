package com.example.shapeolorpp.utills

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.GradientDrawable
import com.example.shapeolorpp.models.LinearShade

object LinearColor {


    fun colorCollector(width: Float, size: Float): ArrayList<LinearShade> {


        val colorCollection = arrayListOf(
            LinearShade(

                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#AF9D5A"),
                    Color.parseColor("#B4161B"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#F4BE2C"),
                        Color.parseColor("#6EC72D")
                    )
                ),
                Color.parseColor("#6EC72D")
            ),
            LinearShade(
                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#758283"),
                    Color.parseColor("#E03B8B"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#758283"),
                        Color.parseColor("#E03B8B")
                    )
                ),
                Color.parseColor("#E03B8B")
            ), LinearShade(
                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#03C6C7"),
                    Color.parseColor("#FF6263"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#03C6C7"),
                        Color.parseColor("#FF6263")
                    )
                ),
                Color.parseColor("#FF6263")
            ), LinearShade(
                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#50DBB4"),
                    Color.parseColor("#EDC126"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#50DBB4"),
                        Color.parseColor("#EDC126")
                    )
                ),
                Color.parseColor("#EDC126")
            ), LinearShade(
                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#6EC72D"),
                    Color.parseColor("#EDC126"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#6EC72D"),
                        Color.parseColor("#EDC126")
                    )
                ),
                Color.parseColor("#EDC126")
            ), LinearShade(
                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#758283"),
                    Color.parseColor("#E03B8B"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#758283"),
                        Color.parseColor("#E03B8B")
                    )
                ),
                Color.parseColor("#E03B8B")
            ), LinearShade(
                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#6A1B4D"),
                    Color.parseColor("#03C6C7"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#6A1B4D"),
                        Color.parseColor("#03C6C7")
                    )
                ),
                Color.parseColor("#03C6C7")
            ), LinearShade(
                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#F4CE6A"),
                    Color.parseColor("#50DBB4"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#F4CE6A"),
                        Color.parseColor("#50DBB4")
                    )
                ),
                Color.parseColor("#50DBB4")
            ), LinearShade(
                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#5A20CB"),
                    Color.parseColor("#03C6C7"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#5A20CB"),
                        Color.parseColor("#03C6C7")
                    )
                ),
                Color.parseColor("#03C6C7")
            ), LinearShade(
                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#B4161B"),
                    Color.parseColor("#8D3DAF"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#B4161B"),
                        Color.parseColor("#8D3DAF")
                    )
                ),
                Color.parseColor("#8D3DAF")
            ), LinearShade(
                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#3DBE29"),
                    Color.parseColor("#EF5354"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#3DBE29"),
                        Color.parseColor("#EF5354")
                    )
                ),
                Color.parseColor("#EF5354")
            ), LinearShade(
                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#5DA3FA"),
                    Color.parseColor("#6EC72D"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#5DA3FA"),
                        Color.parseColor("#6EC72D")
                    )
                ),
                Color.parseColor("#6EC72D")
            ), LinearShade(
                LinearGradient(
                    width, 0.0f, width, size,
                    Color.parseColor("#33FF33"),
                    Color.parseColor("#CC0033"),
                    Shader.TileMode.CLAMP
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#33FF33"),
                        Color.parseColor("#CC0033")
                    )
                ),
                Color.parseColor("#CC0033")
            )
        )


        return colorCollection
    }


}