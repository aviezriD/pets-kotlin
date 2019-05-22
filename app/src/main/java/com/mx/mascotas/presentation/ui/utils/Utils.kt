package com.mx.mascotas.presentation.ui.utils

import android.content.Context
import android.net.ConnectivityManager
import com.mx.mascotas.MascotasAplication

object Utils {

    fun isOnline() : Boolean{
        val cm = MascotasAplication.application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}