package com.example.tap_payment_task.features.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * stating HiltAndroidApp for enabling hilt initialization at the beginning
 * and creating the dependency graph in the first
 */
@HiltAndroidApp
class application : Application() {
}