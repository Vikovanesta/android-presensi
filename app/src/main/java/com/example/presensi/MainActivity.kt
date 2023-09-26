package com.example.presensi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.presensi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

//                btnShowTimePicker.setOnClickListener {
//                    val timePicker = TimePicker()
//                    timePicker.show(supportFragmentManager, "time picker")
//                }
//
//                btnShowCalendar.setOnClickListener {
//                    val datePicker = DatePicker()
//                    datePicker.show(supportFragmentManager, "date picker")
//                }

//            timePicker.setOnTimeChangedListener {_, hourOfDay, minute ->
//                val selectedTime = "$hourOfDay:$minute"
//                Toast.makeText(
//                    this@MainActivity,
//                    selectedTime, Toast.LENGTH_SHORT
//                ).show()
//            }


//            datePicker.init(
//                datePicker.year,
//                datePicker.month,
//                datePicker.dayOfMonth
//            ) {_, year, month, dayOfMonth ->
//                val selectedDate = "$dayOfMonth/${month + 1}/$year"
//                Toast.makeText(
//                    this@MainActivity,
//                    selectedDate, Toast.LENGTH_SHORT
//                ).show()
//            }

            val presensi = resources.getStringArray(R.array.presensi)
            val adapterPresensi = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_spinner_item, presensi)
            spinnerPresensi.adapter = adapterPresensi

            //get selecetd using item on item selected Listener
            spinnerPresensi.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        if (presensi[p2] == "Hadir Tepat Waktu") {
                            etKeterangan.visibility = View.GONE
                        }else{
                            etKeterangan.visibility = View.VISIBLE
                        }
                        Toast.makeText(
                            this@MainActivity,
                            presensi[p2], Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
        }
    }


}