package com.example.errorlogger

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import android.widget.TextView
import com.example.errorlogger.R
import com.example.errorlogger.CrashReportingTree


class MainActivity : AppCompatActivity() {
    private lateinit var errorButton: Button
    private lateinit var clearErrorButton: Button
    private lateinit var errorText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        errorButton = findViewById(R.id.errorButton)
        clearErrorButton = findViewById(R.id.clearErrorButton)
        errorText = findViewById(R.id.errorText)

        // initializing timber with custom CrashReportingTree
        Timber.plant(CrashReportingTree())

        errorButton.setOnClickListener {
            // Log an error when the button is clicked
           val errorMessage = ("Task failed successfully :P")
            Timber.e(errorMessage)

            //Display error message
            errorText.text = "Logged error: $errorMessage"
            errorText.visibility = TextView.VISIBLE

        }

        clearErrorButton.setOnClickListener {
            //clear the message and hide TextView
            errorText.text = ""
            errorText.visibility = TextView.GONE

            //set message for "clear" button
            val clearMessage = "Guess we will ignore it then."
            errorText.text = clearMessage
            errorText.visibility = TextView.VISIBLE
        }
    }
}
