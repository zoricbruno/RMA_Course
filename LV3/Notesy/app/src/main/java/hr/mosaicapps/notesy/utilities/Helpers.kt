package hr.mosaicapps.notesy.utilities

import hr.mosaicapps.notesy.R

fun getColorResource(importance: Int): Int{
    return when(importance){
        1 -> R.color.red
        2 -> R.color.yellow
        else -> R.color.green
    }
}