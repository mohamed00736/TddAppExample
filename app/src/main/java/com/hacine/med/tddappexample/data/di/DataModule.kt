package com.hacine.med.tddappexample.data.di



import com.hacine.med.tddappexample.data.network.api.CoffeeService
import com.hacine.med.tddappexample.data.repository.CoffeeRepositoryImpl
import com.hacine.med.tddappexample.data.source.CoffeeDataSource
import com.hacine.med.tddappexample.data.source.CoffeeDataSourceImpl
import com.hacine.med.tddappexample.domain.repository.CoffeeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun provideCoffeeDataSource(coffeeService: CoffeeService): CoffeeDataSource =
        CoffeeDataSourceImpl(coffeeService)

    @Provides
    fun provideCoffeeRepository(coffeeDataSource: CoffeeDataSource): CoffeeRepository =
        CoffeeRepositoryImpl(coffeeDataSource)

//    @Provides
//    fun provideGetIcedCoffeesUseCaseImpl(repos: CoffeeRepositoryImpl): GetIcedCoffeesUseCase =
//        GetIcedCoffeesUseCaseImpl(repos)
//
//    @Provides
//    fun provideGetHotCoffeesUseCaseImpl(repos: CoffeeRepositoryImpl): GetHotCoffeesUseCase =
//        GetHotCoffeesUseCaseImpl(repos)



}