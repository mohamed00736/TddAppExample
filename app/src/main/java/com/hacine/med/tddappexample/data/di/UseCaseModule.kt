package com.hacine.med.tddappexample.data.di

import com.hacine.med.tddappexample.data.repository.CoffeeRepositoryImpl
import com.hacine.med.tddappexample.domain.usecases.GetHotCoffeesUseCase
import com.hacine.med.tddappexample.domain.usecases.GetHotCoffeesUseCaseImpl
import com.hacine.med.tddappexample.domain.usecases.GetIcedCoffeesUseCase
import com.hacine.med.tddappexample.domain.usecases.GetIcedCoffeesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object   UseCaseModule {

    @Provides
    fun provideGetIcedCoffeesUseCaseImpl(repos: CoffeeRepositoryImpl): GetIcedCoffeesUseCase =
        GetIcedCoffeesUseCaseImpl(repos)

    @Provides
    fun provideGetHotCoffeesUseCaseImpl(repos: CoffeeRepositoryImpl): GetHotCoffeesUseCase =
        GetHotCoffeesUseCaseImpl(repos)
}