package com.sapuglha.beenthere

import android.app.Application
import android.os.StrictMode
import timber.log.Timber

class BeenThereApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initialize()
    }

    private fun initialize() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())

            // strict mode for dev debug versions
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                    .detectCustomSlowCalls()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .penaltyDeath()
                    .build())
            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                    .detectLeakedClosableObjects()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedRegistrationObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build())
        }
    }
}