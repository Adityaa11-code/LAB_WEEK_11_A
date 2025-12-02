package com.example.lab_week_11_a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.content.Context

class MainActivity : AppCompatActivity() {

    private lateinit var inputEt: EditText
    private lateinit var savePrefBtn: Button
    private lateinit var saveDataStoreBtn: Button
    private lateinit var prefValueTv: TextView
    private lateinit var dataStoreValueTv: TextView

    private val PREF_NAME = "my_prefs"
    private val PREF_KEY = "text_value"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEt = findViewById(R.id.input_et)
        savePrefBtn = findViewById(R.id.save_pref_btn)
        saveDataStoreBtn = findViewById(R.id.save_datastore_btn)
        prefValueTv = findViewById(R.id.pref_value_tv)
        dataStoreValueTv = findViewById(R.id.datastore_value_tv)

        val sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        savePrefBtn.setOnClickListener {
            val text = inputEt.text.toString()
            sharedPref.edit().putString(PREF_KEY, text).apply()
            prefValueTv.text = "SharedPref value: $text"
        }

        saveDataStoreBtn.setOnClickListener {
            val text = inputEt.text.toString()
            dataStoreValueTv.text = "DataStore value: $text"
        }

        // load saved data
        val savedText = sharedPref.getString(PREF_KEY, "")
        prefValueTv.text = "SharedPref value: $savedText"
    }
}
