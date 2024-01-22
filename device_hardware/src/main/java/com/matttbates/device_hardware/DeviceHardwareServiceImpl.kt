package com.matttbates.device_hardware

import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

class DeviceHardwareServiceImpl(
    private val context: Context
): DeviceHardwareService {
    override fun vibrate() {
        //vibrate phone
        if (Build.VERSION.SDK_INT >= 31) {
            val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator.vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE))
        } else if (Build.VERSION.SDK_INT >= 26) {
            (context.getSystemService(VIBRATOR_SERVICE) as Vibrator).vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            (context.getSystemService(VIBRATOR_SERVICE) as Vibrator).vibrate(150)
        }
    }
}