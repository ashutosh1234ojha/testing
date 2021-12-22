package com.ashutosh1234ojha.unittestapp.simplifiedcoding.ui

import android.annotation.SuppressLint
import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Ashutosh Ojha on 17,December,2021
 */

fun View.enabled(enable: Boolean) {
    isEnabled = enable
}

fun View.snackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).also {
        it.setAction("Ok") {}
    }.show()
}

@SuppressLint("SimpleDateFormat")
fun Date.toReadableString(): String {
    val format = SimpleDateFormat("yyyy-MM-dd")
    return format.format(this)
}