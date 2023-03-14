package com.example.tap_payment_task.features.tap_payment_bottomSheet.data.di

import com.example.tap_payment_task.features.tap_payment_bottomSheet.data.repository.TapPaymentRepositoryImpl
import com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.repository.TapPaymentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class TapPaymentRepositoriesModule {

    @Provides
    fun bindRepository(): TapPaymentRepository {
        return TapPaymentRepositoryImpl()
    }

}