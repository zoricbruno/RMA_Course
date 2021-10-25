package com.mosaicapps.dicey.utilities

import com.mosaicapps.dicey.R

fun getDieFaceForRolled(number: Int): Int{
    return when(number){
        1 -> R.drawable.one
        2 -> R.drawable.two
        3 -> R.drawable.three
        4 -> R.drawable.four
        5 -> R.drawable.five
        6 -> R.drawable.six
        else -> R.drawable.zero
    }
}