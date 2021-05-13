package com.nafuda.myapplication

import android.content.ContentValues
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.CallLog
import android.provider.CallLog.Calls
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val values1 = ContentValues()
        values1.put(Calls.DATE, System.currentTimeMillis())
        values1.put(Calls.DURATION, 15)
        values1.put(Calls.TYPE, Calls.OUTGOING_TYPE)
        values1.put(Calls.NEW, 1)
        values1.put(Calls.CACHED_NAME, "Hello test")
        values1.put(Calls.PHONE_ACCOUNT_COMPONENT_NAME, "Hello test")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            values1.put(Calls.CALL_SCREENING_APP_NAME, "Hello test")
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            values1.put(Calls.CALL_SCREENING_COMPONENT_NAME, "Hello test")
        }
        values1.put(Calls.PHONE_ACCOUNT_ID, "Hello test")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            values1.put(Calls.VIA_NUMBER, "Hello test")
        }
        values1.put(Calls.CACHED_NUMBER_LABEL, "Hello test")
        values1.put(Calls.CALL_SCREENING_APP_NAME, "Hello test")
        values1.put(Calls.CALL_SCREENING_APP_NAME, "Hello test")
        values1.put(Calls.CACHED_NUMBER_TYPE, 2)
        values1.put(Calls.CACHED_NUMBER_LABEL, 2)

//        contentResolver.update(
//            Uri.parse("content://call_log/calls"),
//            values1,
//            Calls.NUMBER + "=?",
//            null
//        )

        contentResolver.update(
            Calls.CONTENT_URI, values1, Calls.NUMBER + "=?",
            arrayOf("0363891871")
        )

//        contentResolver.insert(
//            Uri.parse("content://call_log/calls"),
//            values1
//        )

    }
}