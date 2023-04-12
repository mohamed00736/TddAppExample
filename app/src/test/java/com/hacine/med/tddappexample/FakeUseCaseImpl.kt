package com.hacine.med.tddappexample


import com.hacine.med.tddappexample.data.model.response.Coffee
import com.hacine.med.tddappexample.data.network.state.Resource
import com.hacine.med.tddappexample.domain.usecases.GetIcedCoffeesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeUseCaseImpl: GetIcedCoffeesUseCase {


    private val fakeFlow = MutableStateFlow<Resource<List<Coffee>>>(Resource.Loading())

    suspend fun mimicResponse(value: Resource<List<Coffee>>) = fakeFlow.emit(value)

    override fun getIcedCoffe(): Flow<Resource<List<Coffee>>> = fakeFlow


}