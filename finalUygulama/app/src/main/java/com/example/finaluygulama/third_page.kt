package com.example.finaluygulama

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment


class third_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_page)

        val button = findViewById<Button>(R.id.button2)

        button.setOnClickListener {

            val pop = PopupMenu(this, button)

            pop.menuInflater.inflate(R.menu.mymenu, pop.menu)
            pop.setOnMenuItemClickListener { i ->

                when (i.itemId) {

                    R.id.rgb -> {
                        callFragment(RGB())
                        true
                    }
                    R.id.snackbar -> {
                        callFragment(SnackBar())
                        true
                    }
                    R.id.exit -> {

                        var isNameCorrect = false
                        var isNumberCorrect = false

                        val correctName = "Omer Sahin"
                        val correctSchoolNumber = "02200201075"

                        val desing = layoutInflater.inflate(R.layout.activity_exit_confirm, null)

                        val alertD = AlertDialog.Builder(this@third_page)
                        alertD.setView(desing)
                        alertD.create().show()

                        val namePlain = desing.findViewById<EditText>(R.id.name)
                        val numberPlain = desing.findViewById<EditText>(R.id.num)
                        val progressBar = desing.findViewById<ProgressBar>(R.id.progressBar3)

                        var preferences = getSharedPreferences(filePath, Context.MODE_PRIVATE)
                        var editor = preferences.edit()


                        namePlain.addTextChangedListener { //isim dogru mu

                            if (namePlain.text.toString() == correctName) isNameCorrect = true

                            if (isNameCorrect && isNumberCorrect) {

                                object : CountDownTimer(1500, 100) {
                                    override fun onTick(p0: Long) {
                                        progressBar.isVisible = true
                                    }

                                    override fun onFinish() {

                                        editor.remove(keyName)
                                        editor.remove(keyNumber)
                                        editor.apply()

                                        val intent = Intent(applicationContext, second_page::class.java)
                                        startActivity(intent)
                                        finish()
                                    }

                                }.start()

                            }

                        }

                        numberPlain.addTextChangedListener { //numara dogru mu

                            if (numberPlain.text.toString() == correctSchoolNumber) isNumberCorrect = true

                            if (isNameCorrect && isNumberCorrect) {

                                object : CountDownTimer(1500, 100) {
                                    override fun onTick(p0: Long) {
                                        progressBar.isVisible = true
                                    }

                                    override fun onFinish() {

                                        editor.remove(keyName)
                                        editor.remove(keyNumber)
                                        editor.apply()

                                        val intent =
                                            Intent(applicationContext, second_page::class.java)
                                        startActivity(intent)
                                        finish()
                                    }

                                }.start()

                            }

                        }

                        true
                    }
                    else -> false

                }

            }

            pop.show()

        }


    }

    fun callFragment(section: Fragment) {

        var intent = supportFragmentManager.beginTransaction()
        intent.replace(R.id.fragmentContainerView, section)
        intent.commit()

    }

}