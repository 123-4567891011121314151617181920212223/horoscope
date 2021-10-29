package com.example.horoscope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.IndexOutOfBoundsException

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spinnerSign: Spinner = findViewById(R.id.spinner_sign)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
                this,
                R.array.signs,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerSign.adapter = adapter
        }


        val spinnerDay: Spinner = findViewById(R.id.spinner_day)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.days,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerDay.adapter = adapter
        }

        val start : Button = findViewById(R.id.start)

        start.setOnClickListener() {
            val setSign = spinnerSign.selectedItem.toString()
            val setDay = spinnerDay.selectedItem.toString()

            val intent = Intent(Intent(this@MainActivity, HoroskopActivity::class.java))
            intent.putExtra("url", createURL(setSign, setDay))
            startActivity(intent)
        }




    }

    private fun createURL(sign : String, date: String) : String {
        return "https://aztro.sameerkumar.website/?sign=$sign&day=$date"
    }
}