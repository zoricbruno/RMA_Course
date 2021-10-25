package com.mosaicapps.dicey.sounds

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import com.mosaicapps.dicey.R

class SoundPoolPlayer(context: Context) : AudioPlayer {

    private val priority: Int = 1
    private val maxStreams: Int = 3
    private val srcQuality: Int = 1

    private val leftVolume = 1f
    private val righVolume = 1f
    private val shouldLoop = 0
    private val playbackRate = 1f

    private val soundPool: SoundPool
    private val rollingSoundId: Int

    init {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build()
            soundPool = SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(maxStreams)
                .build()
        } else {
            soundPool = SoundPool(maxStreams, AudioManager.USE_DEFAULT_STREAM_TYPE, srcQuality)
        }

        rollingSoundId = soundPool.load(context, R.raw.diceroll, priority)
    }

    override fun playRollingSound() {
        soundPool.play(rollingSoundId, leftVolume, righVolume, priority, shouldLoop, playbackRate)
    }
}