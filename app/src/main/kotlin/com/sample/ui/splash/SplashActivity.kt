package com.sample.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.sample.ui.main.activities.MainActivity
import com.sample.ui.splash.SplashActivityViewModel.Constants.SPLASH_DELAY

/**
 * Splash screen with background
 */
class SplashActivity : AppCompatActivity() {

    // region Variables

    private val runnable by lazy {
        val runnable = Runnable {
            moveToNextScreen()
        }
        runnable
    }

    private val handler by lazy {
        val handler = Handler(Looper.getMainLooper())
        handler
    }

    //endregion Variables

    // region LIFECYCLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handler.postDelayed(runnable, SPLASH_DELAY)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }

    // endregion

    // region UTIL

    private fun moveToNextScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    // endregion
}
