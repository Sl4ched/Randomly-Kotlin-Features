package com.example.finaluygulama

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.ProgressBar
import android.widget.SeekBar
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekbar = findViewById<SeekBar>(R.id.seekBar)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        var seek = 0
        var goBack = 100

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seek = p1
            }


            override fun onStartTrackingTouch(p0: SeekBar?) {
                seekbar.thumb.setTint(Color.parseColor("#007E3D"))
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                seekbar.thumb.setTint(Color.parseColor("#006384"))

                if (seek < 100) seekbar.progress = 0
                else {
                    progressBar.isVisible = true
                    object : CountDownTimer(1000, 10) {
                        override fun onTick(p0: Long) {
                            if (goBack >= 0) goBack -= 4
                            seekbar.progress = goBack
                        }

                        override fun onFinish() {
                        }
                    }.start()

                    Handler().postDelayed({
                        val intent = Intent(applicationContext, second_page::class.java)
                        startActivity(intent)
                        finish()
                    }, 2000)

                }
            }
        })


    }
}