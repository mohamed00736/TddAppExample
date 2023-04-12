package com.hacine.med.tddappexample

import com.hacine.med.tddappexample.data.di.UseCaseModule
import com.hacine.med.tddappexample.data.model.response.Coffee
import com.hacine.med.tddappexample.data.network.state.Resource
import com.hacine.med.tddappexample.domain.usecases.GetHotCoffeesUseCase
import com.hacine.med.tddappexample.domain.usecases.GetIcedCoffeesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Singleton


@TestInstallIn(components = [ViewModelComponent::class],
    replaces = [UseCaseModule::class])
@Module
object FakeDataModule {

    @Provides
    fun getIcedCoffees() = object : GetIcedCoffeesUseCase {

        val listofCoffe = listOf(
            Coffee("Espresso ","Espresso Coffe2", listOf("ing1" ,"ing2"),"imgurl" , id = "1" ),
            Coffee("Mocha","Mocha Coffe2", listOf("ing1" ,"ing2"),"imgurl" , id = "2" ),
        )
        private val fakeFlow = MutableStateFlow<Resource<List<Coffee>>>(Resource.Success(listofCoffe))
       @ExperimentalCoroutinesApi
        override fun getIcedCoffe(): Flow<Resource<List<Coffee>>> {
          return  fakeFlow
        }
    }

    @Provides
    fun getHotCoffee() = object : GetHotCoffeesUseCase {

        val listofCoffe = listOf(
            Coffee("moca","haha", listOf("" ,""),"imgurl" , id = "1" ),
            Coffee("Normal","haha", listOf("" ,""),"imgurl" , id = "2" ),
        )
        private val fakeFlow = MutableStateFlow<Resource<List<Coffee>>>(Resource.Success(listofCoffe))

        @ExperimentalCoroutinesApi
        override fun getHotCoffee(): Flow<Resource<List<Coffee>>> {
            return  fakeFlow
        }
    }

}