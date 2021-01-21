package com.saad.maximatechtest.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class AppConnectivityManager(private val context: Context) : ConnectionManager {
    override fun isConnectionAvailable(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnected ?: false
    }
}