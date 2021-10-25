package com.mosaicapps.dicey.di

import com.mosaicapps.dicey.sensors.AccelerationSensor
import com.mosaicapps.dicey.sensors.AndroidAccelerationSensor
import com.mosaicapps.dicey.sounds.AudioPlayer
import com.mosaicapps.dicey.sounds.SoundPoolPlayer
import com.mosaicapps.dicey.ui.DiceViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory<AccelerationSensor> { AndroidAccelerationSensor(androidContext()) }
    single<AudioPlayer> { SoundPoolPlayer(androidContext()) }
}

val viewModelModule = module {
    viewModel<DiceViewModel> { DiceViewModel(get(), get()) }
}