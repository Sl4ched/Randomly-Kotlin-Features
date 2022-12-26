package com.example.finaluygulama

import android.media.Image
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible

class FragmentMain : Fragment() {

    lateinit var mfImg: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {

            mfImg = it.findViewById(R.id.imageView3)

            object : CountDownTimer(100000,500){
                override fun onTick(p0: Long) {
                    if(mfImg.isVisible) mfImg.visibility = View.INVISIBLE
                    else mfImg.visibility = View.VISIBLE

                }

                override fun onFinish() {
                }

            }.start()


        }
    }



}


