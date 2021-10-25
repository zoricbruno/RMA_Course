package com.mosaicapps.dicey.ui

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.mosaicapps.dicey.databinding.ActivityDiceBinding
import com.mosaicapps.dicey.utilities.getDieFaceForRolled
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiceActivity : AppCompatActivity() {

    private val viewModel by viewModel<DiceViewModel>()
    private lateinit var binding: ActivityDiceBinding
    private lateinit var dice: List<ImageButton>
    private val accelerationFormat = "%.4f"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiceBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.ibRoll.setOnClickListener { rollDice() }
            dice = listOf(
                it.ibDieTopLeft, it.ibDieTopCenter, it.ibDieTopRight,
                it.ibDieBotLeft, it.ibDieBotCenter, it.ibDieBotRight
            )
        }
        viewModel.apply {
            getAccelerationData().observe(this@DiceActivity, { onAccelerationChanged(it) })
            dice.observe(this@DiceActivity, { updateDice(it) })
        }
    }

    private fun updateDice(numbers: List<Int>) {
        dice.zip(numbers).forEach { (dice, number) ->
            dice.setImageResource(getDieFaceForRolled(number))
        }
    }

    private fun rollDice() {
        viewModel.playRollingSound()
        viewModel.rollDice()
    }

    private fun onAccelerationChanged(acceleration: Double) {
        binding.tvAccelerationMagnitude.text = accelerationFormat.format(acceleration)
        rollDice()
    }


}