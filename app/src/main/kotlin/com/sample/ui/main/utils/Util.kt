package com.sample.ui.main.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import com.sample.ui.ClassifiedApp

/**
 * Utility file for performing all utility generic operation, all the methods defined here
 * can access from through out the project
 */
fun showToast(context: Context, str: String) {
    Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
}

fun hasInternetConnection(): Boolean {
    val cm =
        ClassifiedApp.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    return try {
        val activeNetwork =
            cm?.activeNetworkInfo
        activeNetwork != null && (activeNetwork.isConnected || activeNetwork.type == ConnectivityManager.TYPE_ETHERNET)
    } catch (e: RuntimeException) {
        true
    }
}
