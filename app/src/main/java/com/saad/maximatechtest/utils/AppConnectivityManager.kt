package com.saad.maximatechtest.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import javax.inject.Inject

class AppConnectivityManager @Inject constructor(val connectivityManager: ConnectivityManager) : ConnectionManager {
    override fun isConnectionAvailable(): Boolean {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnected ?: false
    }
}