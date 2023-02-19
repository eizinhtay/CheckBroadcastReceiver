package com.example.checkbroadcastreceiver

import android.app.Service
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.IBinder
import android.util.Log
import android.widget.Toast


class ConnectionService : Service(){

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val connectivityManager =
            getSystemService(ConnectivityManager::class.java) as ConnectivityManager
        val activeNetwork: NetworkInfo = connectivityManager.activeNetworkInfo!!
        Log.d("tagLog", "Manager Online${activeNetwork.state}")

        Toast.makeText(applicationContext, "connected:: ${activeNetwork.state}", Toast.LENGTH_SHORT).show()

        return START_STICKY

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

//        if (activeNetwork?.isConnectedOrConnecting == true && activeNetwork.isAvailable) {
//            Log.d("tagLog", "${activeNetwork.state}")
//            when (activeNetwork.state) {
//                NetworkInfo.State.CONNECTED -> {
//                    Log.d("tagLog", " CONNECTED ")
//                    //return true
//                }
//                NetworkInfo.State.CONNECTING -> {
//                    Log.d("tagLog", " CONNECTING ")
//                    //return true
//                }
//                else -> {
//                    Log.d("tagLog", "NO Connection")
//                    //return false
//                }
//            }
//
//        }