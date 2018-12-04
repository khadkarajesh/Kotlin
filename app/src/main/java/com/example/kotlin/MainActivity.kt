package com.example.kotlin

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import com.example.extensions.edit
import com.example.extensions.sharedPreferences


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<EditText>(R.id.edit_text).trimmedValue

        //without using extension functions
        val editor = getSharedPreferences("my_pref", Context.MODE_PRIVATE).edit()
        editor.putString("name", "rajesh")
        editor.putInt("age", 21)
        editor.apply()

        //using extension function
        sharedPreferences.edit {
            putString("name", "rajesh")
            putInt("age", 21)
        }
    }


    //property extension function
    val EditText.trimmedValue: String get() = text.toString().trim()
}
