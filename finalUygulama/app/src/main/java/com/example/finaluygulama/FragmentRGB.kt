package com.example.finaluygulama

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
class RGB : Fragment() {

    lateinit var redd: SeekBar
    lateinit var greenn: SeekBar
    lateinit var bluee: SeekBar
    lateinit var references: TextView
    lateinit var fragmentt: View


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_r_g_b, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {

            redd = it.findViewById(R.id.red)
            greenn = it.findViewById(R.id.green)
            bluee = it.findViewById(R.id.blue)
            references = it.findViewById(R.id.colorCode)
            fragmentt = it.findViewById(R.id.fragment)

            var r: Int
            var g : Int
            var b : Int

            var rS = "00"
            var gS = "bc"
            var bS = "d4"

            var colorHash = ""

            redd.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    r = p1
                    rS = Integer.toHexString(r)
                    if (rS.length == 1) rS = "0" + rS
                    colorHash =  "#" + rS + gS + bS
                    references.setText(colorHash)
                    fragmentt.setBackgroundColor(Color.parseColor(colorHash))

                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                }

            })

            bluee.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    b = p1
                    bS = Integer.toHexString(b)
                    if (bS.length == 1) bS = "0" + bS
                    colorHash = "#" + rS + gS + bS
                    references.setText(colorHash)
                    fragmentt.setBackgroundColor(Color.parseColor(colorHash))


                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                }

            })

            greenn.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    g = p1
                    gS = Integer.toHexString(g)
                    if (gS.length == 1) gS = "0" + gS
                    colorHash = "#" + rS + gS + bS
                    references.setText(colorHash)
                    fragmentt.setBackgroundColor(Color.parseColor(colorHash))

                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                }

            })


        }
    }

}
