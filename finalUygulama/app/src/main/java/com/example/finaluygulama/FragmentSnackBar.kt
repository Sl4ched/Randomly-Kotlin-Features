package com.example.finaluygulama

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.snackbar.Snackbar

lateinit var msgText1: EditText
lateinit var msgText2: EditText
lateinit var spin: Spinner

class SnackBar : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_snack_bar, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {

            spin = it.findViewById(R.id.spinner)
            msgText1 = it.findViewById(R.id.editTextTextPersonName2)
            msgText2 = it.findViewById(R.id.editTextTextPersonName3)

            var colours = arrayOf("Süre Seçiniz","2 sn", "2.5 sn", "3 sn", "3.5 sn", "4 sn")
            var adapter = ArrayAdapter(
                activity!!,
                android.R.layout.simple_dropdown_item_1line,
                colours
            )

            spin.adapter = adapter

            spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {


                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    when(p0?.getItemAtPosition(p2)){

                        "2 sn" ->{
                            Snackbar.make(view, msgText1.text.toString(),2000).setAction(msgText2.text.toString()){

                                    Toast.makeText(context, msgText2.text.toString(),Toast.LENGTH_LONG).show()

                                }.show()
                        }

                        "2.5 sn" ->{
                            Snackbar.make(view, msgText1.text.toString(),2500).setAction(msgText2.text.toString()){

                                Toast.makeText(context, msgText2.text.toString(),Toast.LENGTH_LONG).show()

                            }.show()

                        }

                        "3 sn" ->{
                            Snackbar.make(view, msgText1.text.toString(),3000).setAction(msgText2.text.toString()){

                                Toast.makeText(context, msgText2.text.toString(),Toast.LENGTH_LONG).show()

                            }.show()

                        }

                        "3.5 sn" ->{
                            Snackbar.make(view, msgText1.text.toString(),3500).setAction(msgText2.text.toString()){

                                Toast.makeText(context, msgText2.text.toString(),Toast.LENGTH_LONG).show()

                            }.show()

                        }

                        "4 sn" ->{
                            Snackbar.make(view, msgText1.text.toString(),4000).setAction(msgText2.text.toString()){

                                Toast.makeText(context, msgText2.text.toString(),Toast.LENGTH_LONG).show()

                            }.show()

                        }

                    }



                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }


        }

    }

}