package com.ashutosh1234ojha.unittestapp.codingwithmitch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ashutosh1234ojha.unittestapp.R
import com.bumptech.glide.Glide

/**
 * Created by Ashutosh Ojha on 30,December,2021
 */
class IntenttActivity : AppCompatActivity() {

    lateinit var image: ImageView

    private val TAG: String = "AppDebug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_itent)

        val btn = findViewById<TextView>(R.id.button_open_gallery)
        image = findViewById<ImageView>(R.id.image)

        btn.setOnClickListener {
            pickFromGallery()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            Log.d(TAG, "RESULT_OK")
            when (requestCode) {

                210 -> {
                    Log.d(TAG, "GALLERY_REQUEST_CODE detected.")
                    data?.data?.let { uri ->
                        Log.d(TAG, "URI: $uri")
                        Glide.with(this)
                            .load(uri)
                            .into(image)
                    }
                }
            }
        }
    }

    private fun pickFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, 210)
    }

}