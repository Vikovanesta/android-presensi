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

            val presensi = resources.getStringArray(R.array.presensi)
            val adapterPresensi = ArrayAdapter<String>(
                this@MainActivity,
                android.R.layout.simple_spinner_item,
                presensi
            )
            spinnerPresensi.adapter = adapterPresensi

            spinnerPresensi.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        if (presensi[p2] == "Hadir Tepat Waktu") {
                            etKeterangan.visibility = View.GONE
                        } else {
                            etKeterangan.visibility = View.VISIBLE
                        }
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {

                    }
                }

            btnSubmit.setOnClickListener {
                val presensi = spinnerPresensi.selectedItem.toString()
                val keterangan = etKeterangan.text.toString()
                val months = resources.getStringArray(R.array.months)
                val month = months[datePicker.month]
                val tanggal =
                    datePicker.dayOfMonth.toString() + " $month " + datePicker.year.toString()
                val jam = timePicker.hour.toString() + ":" + timePicker.minute.toString()

                if ((presensi != "Hadir Tepat Waktu" && keterangan.isNotEmpty()) || presensi == "Hadir Tepat Waktu") {
                    Toast.makeText(
                        this@MainActivity,
                        "Presensi berhasil $tanggal jam $jam dengan status $presensi",
                        Toast.LENGTH_SHORT
                    ).show()
                }else{
                    Toast.makeText(
                        this@MainActivity,
                        "Presensi gagal, keterangan tidak boleh kosong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


}