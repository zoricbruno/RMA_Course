package com.mosaicapps.dicey.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.LiveData

class AndroidAccelerationSensor(context: Context) : LiveData<Double>(), SensorEventListener, AccelerationSensor {

    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    private val minTimeToUpdate = 300L
    private var lastUpdate = System.currentTimeMillis()
    private val accelerationThreshold = 11

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        sensorEvent?.let {

            if (System.currentTimeMillis() - lastUpdate <= minTimeToUpdate)
                return

            val acceleration = Math.sqrt(
                it.values
                    .map { value -> value.toDouble() * value.toDouble() }
                    .sum()
            )

            if (acceleration > accelerationThreshold)
                this.value = acceleration

            lastUpdate = System.currentTimeMillis()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onActive() {
        super.onActive()
        sensorManager.registerListener(this, accelerationSensor, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onInactive() {
        super.onInactive()
        sensorManager.unregisterListener(this)
    }

    override fun getAcceleration(): LiveData<Double> {
        return this
    }
}