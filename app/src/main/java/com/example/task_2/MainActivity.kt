package com.example.task_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    var clickCountMap = mutableMapOf<String , Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickCountDisplayView = findViewById<TextView>(R.id.clickCountView)
        val clickMeCount = findViewById<TextView>(R.id.clickButton)
        val inputTextName = findViewById<TextInputLayout>(R.id.textInput)

        clickMeCount.setOnClickListener {
            val userName = inputTextName.editText?.text?.toString()
            val maskUserName =
                if (userName.isNullOrEmpty()) "SomeBody"
                else userName

            val oldUserClick = clickCountMap[maskUserName] ?: 0
            val newUserClick = oldUserClick + 1

            clickCountMap[maskUserName] = newUserClick

            clickCountDisplayView.text = "$maskUserName clicked $newUserClick times"
        }
    }

}