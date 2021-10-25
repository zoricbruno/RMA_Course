package com.mosaicapps.dicey.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mosaicapps.dicey.sensors.AccelerationSensor
import com.mosaicapps.dicey.sounds.AudioPlayer
import kotlin.random.Random

class DiceViewModel(
    private val accelerationSensor: AccelerationSensor,
    private val audioPlayer: AudioPlayer
) : ViewModel() {

    private val diceCount: Int = 6
    private val minValue = 1
    private val maxValue = 6

    private val _dice = MutableLiveData(List(diceCount) { 0 })
    val dice: LiveData<List<Int>> = _dice

    fun getAccelerationData() = accelerationSensor.getAcceleration()
    fun playRollingSound() = audioPlayer.playRollingSound()
    fun rollDice() {
        _dice.value = List<Int>(diceCount) { Random.nextInt(minValue, maxValue + 1) }
    }
}