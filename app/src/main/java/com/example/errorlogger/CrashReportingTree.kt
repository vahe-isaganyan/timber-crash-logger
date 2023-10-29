package com.example.errorlogger

import android.util.Log
import timber.log.Timber

class CrashReportingTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.ERROR) {
            // application can be tailored to define how to handle error logs.
            // for now, we are simply logging to Logcat.
            Log.e(tag, message)
        }
    }
}
