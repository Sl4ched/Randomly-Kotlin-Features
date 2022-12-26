package com.example.finaluygulama

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener

val filePath = "com.example.finaluygulama"
val correctName = "Omer Sahin"
val correctSchoolNumber = "02200201075"

val keyName = "name"
val keyNumber = "number"
var rememberMe = "false"


class second_page : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        val namePlain = findViewById<EditText>(R.id.editTextTextPersonName)
        val numberPlain = findViewById<EditText>(R.id.editTextTextPassword)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar2)
        val switch = findViewById<Switch>(R.id.switch1)

        var preferences = getSharedPreferences(filePath, Context.MODE_PRIVATE)
        var editor = preferences.edit()

        var isNameCorrect = false
        var isNumberCorrect = false

        namePlain.setText(preferences.getString(keyName, ""))
        numberPlain.setText(preferences.getString(keyNumber, ""))

        if (namePlain.text.toString() == correctName && numberPlain.text.toString() == correctSchoolNumber) {
            rememberMe = "true"
            switch.isChecked = true

            object : CountDownTimer(1500, 100) {
                override fun onTick(p0: Long) {
                    progressBar.isVisible = true
                }

                override fun onFinish() {
                    val intent = Intent(applicationContext, third_page::class.java)
                    startActivity(intent)
                    finish()
                }

            }.start()

        } else {
            rememberMe = "false"
            switch.isChecked = false
        }

        Toast.makeText(
            applicationContext,
            "Kaydedilmiş\nİsim:${preferences.getString(keyName, "Değer Yok")}\n" +
                    "Şifre:${preferences.getString(keyNumber, "Değer Yok")}\n" +
                    "Unutma:${rememberMe}",
            Toast.LENGTH_LONG
        ).show()


        switch.setOnCheckedChangeListener { compoundButton, b -> //beni hatirla acik mi
            if (switch.isChecked) {
                rememberMe = "true"
            } else if (!switch.isChecked) {
                rememberMe = "false"
            }
        }

        namePlain.addTextChangedListener { //isim dogru mu

            if (namePlain.text.toString() == correctName) isNameCorrect = true

            if (isNameCorrect && isNumberCorrect) {

                if (rememberMe == "true") {
                    editor.putString(keyName, namePlain.text.toString())
                    editor.putString(keyNumber, numberPlain.text.toString())
                    editor.apply()
                }

                object : CountDownTimer(1500, 100) {
                    override fun onTick(p0: Long) {
                        progressBar.isVisible = true
                    }

                    override fun onFinish() {
                        val intent = Intent(applicationContext, third_page::class.java)
                        startActivity(intent)
                        finish()
                    }

                }.start()

            }

        }

        numberPlain.addTextChangedListener { //numara dogru mu

            if (numberPlain.text.toString() == correctSchoolNumber) isNumberCorrect = true

            if (isNameCorrect && isNumberCorrect) {

                if (rememberMe == "true") {

                    editor.putString(keyName, namePlain.text.toString())
                    editor.putString(keyNumber, numberPlain.text.toString())
                    editor.apply()

                }

                object : CountDownTimer(1500, 100) {
                    override fun onTick(p0: Long) {
                        progressBar.isVisible = true
                    }

                    override fun onFinish() {
                        val intent = Intent(applicationContext, third_page::class.java)
                        startActivity(intent)
                        finish()
                    }

                }.start()

            }

        }

    }
}