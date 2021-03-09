package com.example.shapeolorpp.utills

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.SweepGradient
import android.graphics.drawable.GradientDrawable
import com.example.shapeolorpp.models.Sweeper
import kotlin.random.Random


object SweeperColor {


    fun sweeperColor(context: Context?, size: Point): ArrayList<Sweeper> {


        val random = Random
        val data = arrayListOf<Sweeper>(


            Sweeper(

                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),
                    intArrayOf(
                        Color.parseColor("#F4BE2C"),
                        Color.parseColor("#E03B8B"),
                        Color.parseColor("#35BDD0"),
                        Color.parseColor("#6EC72D")
                    ),
                    null // Position is undefined
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#F4BE2C"),
                        Color.parseColor("#6EC72D")
                    )
                ),
                Color.parseColor("#6EC72D")
            ), Sweeper(
                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),
                    intArrayOf(
                        Color.parseColor("#758283"),
                        Color.parseColor("#E03B8B"),
                        Color.parseColor("#758283"),
                        Color.parseColor("#E03B8B")
                    ),
                    null // Position is undefinedndefined
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#758283"),
                        Color.parseColor("#E03B8B")
                    )
                ),
                Color.parseColor("#E03B8B")
            ), Sweeper(
                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),
                    intArrayOf(
                        Color.parseColor("#50DBB4"),
                        Color.parseColor("#EDC126")
                    ),
                    null // Position is undefined
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#50DBB4"),
                        Color.parseColor("#EDC126")
                    )
                ),
                Color.parseColor("#EDC126")
            ), Sweeper(
                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),

                    intArrayOf(
                        Color.parseColor("#758283"),
                        Color.parseColor("#E03B8B")
                    ),
                    null // Position is undefined
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#758283"),
                        Color.parseColor("#E03B8B")
                    )
                ),
                Color.parseColor("#E03B8B")


            ), Sweeper(
                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),

                    intArrayOf(
                        Color.parseColor("#6A1B4D"),
                        Color.parseColor("#03C6C7")
                    ),
                    null // Position is undefined
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#6A1B4D"),
                        Color.parseColor("#03C6C7")
                    )
                ),
                Color.parseColor("#03C6C7")

            ), Sweeper(
                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),

                    intArrayOf(
                        Color.parseColor("#F4CE6A"),
                        Color.parseColor("#50DBB4")
                    ),
                    null // Position is undefined
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#F4CE6A"),
                        Color.parseColor("#50DBB4")
                    )
                ),
                Color.parseColor("#50DBB4")

            ), Sweeper(
                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),

                    intArrayOf(
                        Color.parseColor("#5A20CB"),
                        Color.parseColor("#03C6C7")
                    ),
                    null // Position is undefined
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#5A20CB"),
                        Color.parseColor("#03C6C7")
                    )
                ),
                Color.parseColor("#03C6C7")

            ), Sweeper(
                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),

                    intArrayOf(
                        Color.parseColor("#B4161B"),
                        Color.parseColor("#8D3DAF")
                    ),
                    null // Position is undefined
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#B4161B"),
                        Color.parseColor("#8D3DAF")
                    )
                ),
                Color.parseColor("#8D3DAF")

            ), Sweeper(
                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),

                    intArrayOf(
                        Color.parseColor("#3DBE29"),
                        Color.parseColor("#EF5354")
                    ),
                    null // Position is undefined
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#3DBE29"),
                        Color.parseColor("#EF5354")
                    )
                ),
                Color.parseColor("#EF5354")

            ), Sweeper(
                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),

                    intArrayOf(
                        Color.parseColor("#5DA3FA"),
                        Color.parseColor("#6EC72D")
                    ),
                    null // Position is undefined
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#5DA3FA"),
                        Color.parseColor("#6EC72D")
                    )
                ),
                Color.parseColor("#6EC72D")

            ), Sweeper(
                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),

                    intArrayOf(
                        Color.parseColor("#33FF33"),
                        Color.parseColor("#CC0033")
                    ),
                    null // Position is undefined
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#33FF33"),
                        Color.parseColor("#CC0033")
                    )
                ),
                Color.parseColor("#CC0033")

            ), Sweeper(
                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),

                    intArrayOf(
                        Color.parseColor("#03C6C7"),
                        Color.parseColor("#FF6263")
                    ),
                    null // Position is undefined
                ),
                GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(
                        Color.parseColor("#03C6C7"),
                        Color.parseColor("#FF6263")
                    )
                ),
                Color.parseColor("#FF6263")
            ), Sweeper(
                SweepGradient(
                    random.nextInt((size.x)).toFloat(), random.nextInt((size.y)).toFloat(),

                    intArrayOf(
                        Color.parseColor("#33FF33"),
                        Color.parseColor("#CC0033")
                    ),
                    null // Position is undefined
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
        return data
    }

}