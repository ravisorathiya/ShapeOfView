package com.example.shapeolorpp.utills

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import com.example.shapeolorpp.models.BackColorV

object BodyVerticle {


    fun verticleColor(): ArrayList<BackColorV> {
        val colorCollection = arrayListOf(
            BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                        Color.parseColor("#F4BE2C"),
                        Color.parseColor("#6EC72D")
                    )
                ),
                Color.parseColor("#6EC72D")
            ),BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                        Color.parseColor("#758283"),
                        Color.parseColor("#E03B8B")
                    )
                ),
                Color.parseColor("#E03B8B")
            ),BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                        Color.parseColor("#03C6C7"),
                        Color.parseColor("#FF6263")
                    )
                ),
                Color.parseColor("#FF6263")
            ),BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                        Color.parseColor("#50DBB4"),
                        Color.parseColor("#EDC126")
                    )
                ),
                Color.parseColor("#EDC126")
            ),BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                        Color.parseColor("#6EC72D"),
                        Color.parseColor("#EDC126")
                    )
                ),
                Color.parseColor("#EDC126")
            ),BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                        Color.parseColor("#758283"),
                        Color.parseColor("#E03B8B")
                    )
                ),
                Color.parseColor("#E03B8B")
            ),BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                        Color.parseColor("#6A1B4D"),
                        Color.parseColor("#03C6C7")
                    )
                ),
                Color.parseColor("#03C6C7")
            ),BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                        Color.parseColor("#F4CE6A"),
                        Color.parseColor("#50DBB4")
                    )
                ),
                Color.parseColor("#50DBB4")
            ),BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                        Color.parseColor("#5A20CB"),
                        Color.parseColor("#03C6C7")
                    )
                ),
                Color.parseColor("#03C6C7")
            ),BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                        Color.parseColor("#B4161B"),
                        Color.parseColor("#8D3DAF")
                    )
                ),
                Color.parseColor("#8D3DAF")
            ),BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                        Color.parseColor("#3DBE29"),
                        Color.parseColor("#EF5354")
                    )
                ),
                Color.parseColor("#EF5354")
            ),BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                        Color.parseColor("#5DA3FA"),
                        Color.parseColor("#6EC72D")
                    )
                ),
                Color.parseColor("#6EC72D")
            ),BackColorV(
                GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
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