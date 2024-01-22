package com.matttbates.device_hardware.di

import android.content.Context
import com.matttbates.device_hardware.DeviceHardwareService
import com.matttbates.device_hardware.DeviceHardwareServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DeviceHardwareModule {

    @Provides
    fun provideDeviceHardwareService(
        @ApplicationContext context: Context
    ): DeviceHardwareService {
        return DeviceHardwareServiceImpl(context)
    }

}