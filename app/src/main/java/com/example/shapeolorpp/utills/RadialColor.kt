package com.example.shapeolorpp.utills

import android.graphics.Color
import android.graphics.RadialGradient
import android.graphics.Shader
import android.graphics.drawable.GradientDrawable
import com.example.shapeofview.data.RadialShade


object RadialColor {


    fun radialColorObj(width: Float, size: Float): ArrayList<RadialShade> {
        val fontRadialColor =
            arrayListOf(
                RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#AF9D5A"),
                        Color.parseColor("#50DBB4"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#AF9D5A"),
                            Color.parseColor("#50DBB4")

                        )),
                    Color.parseColor("#50DBB4")

                ),
                RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#758283"),
                        Color.parseColor("#E03B8B"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#758283"),
                            Color.parseColor("#E03B8B")

                        )),
                    Color.parseColor("#E03B8B")

                ), RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#03C6C7"),
                        Color.parseColor("#FF6263"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#03C6C7"),
                            Color.parseColor("#FF6263")

                        )),
                    Color.parseColor("#FF6263")

                ), RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#C9B3E0"),
                        Color.parseColor("#12B0E8"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#C9B3E0"),
                            Color.parseColor("#12B0E8")

                        )),
                    Color.parseColor("#12B0E8")

                ), RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#6EC72D"),
                        Color.parseColor("#EDC126"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#6EC72D"),
                            Color.parseColor("#EDC126")

                        )),
                    Color.parseColor("#EDC126")

                ), RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#758283"),
                        Color.parseColor("#E03B8B"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#758283"),
                            Color.parseColor("#E03B8B")

                        )),
                    Color.parseColor("#E03B8B")

                ), RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#6A1B4D"),
                        Color.parseColor("#03C6C7"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#6A1B4D"),
                            Color.parseColor("#03C6C7")

                        )),
                    Color.parseColor("#03C6C7")

                ), RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#F4CE6A"),
                        Color.parseColor("#50DBB4"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#F4CE6A"),
                            Color.parseColor("#50DBB4")

                        )),
                    Color.parseColor("#50DBB4")

                ), RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#5A20CB"),
                        Color.parseColor("#03C6C7"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#5A20CB"),
                            Color.parseColor("#03C6C7")

                        )),
                    Color.parseColor("#03C6C7")

                ), RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#B4161B"),
                        Color.parseColor("#8D3DAF"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#B4161B"),
                            Color.parseColor("#8D3DAF")

                        )),
                    Color.parseColor("#8D3DAF")

                ), RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#3DBE29"),
                        Color.parseColor("#EF5354"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#3DBE29"),
                            Color.parseColor("#EF5354")

                        )),
                    Color.parseColor("#EF5354")

                ), RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#5DA3FA"),
                        Color.parseColor("#6EC72D"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#5DA3FA"),
                            Color.parseColor("#6EC72D")
                        )),
                    Color.parseColor("#6EC72D")

                ), RadialShade(
                    RadialGradient(
                        5f, 3f, 200f,
                        Color.parseColor("#33FF33"),
                        Color.parseColor("#CC0033"),
                        Shader.TileMode.MIRROR
                    ),
                    GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                            Color.parseColor("#33FF33"),
                            Color.parseColor("#CC0033")
                        )),
                    Color.parseColor("#CC0033")

                )
            )
        return fontRadialColor
    }


}