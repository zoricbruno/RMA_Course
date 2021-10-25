package com.mosaicapps.dicey.sensors

import androidx.lifecycle.LiveData

interface AccelerationSensor{
    fun getAcceleration(): LiveData<Double>
}