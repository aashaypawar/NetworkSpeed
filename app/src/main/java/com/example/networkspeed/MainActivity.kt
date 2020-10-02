package com.example.networkspeed

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cm = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nc = cm.getNetworkCapabilities(cm.activeNetwork)
        val downSpeed = nc.linkDownstreamBandwidthKbps
        val upSpeed = nc.linkUpstreamBandwidthKbps

        Toast.makeText(applicationContext,"Up Speed: $upSpeed kbps \nDown Speed: $downSpeed kbps",Toast.LENGTH_LONG).show()
    }
}