package com.example.errorlogger

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import com.example.errorlogger.R
import com.example.errorlogger.CrashReportingTree



class MainActivity : AppCompatActivity() {
    private lateinit var errorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        errorButton = findViewById(R.id.errorButton)

        // initializing timber with custom CrashReportingTree
        Timber.plant(CrashReportingTree())

        errorButton.setOnClickListener {
            // Log an error when the button is clicked
            Timber.e("Task failed successfully :P")
        }
    }
}
