package com.hacine.med.tddappexample.domain.usecases

import com.hacine.med.tddappexample.data.model.response.Coffee
import com.hacine.med.tddappexample.data.network.state.Resource
import kotlinx.coroutines.flow.Flow

interface GetIcedCoffeesUseCase {
    fun getIcedCoffe(): Flow<Resource<List<Coffee>>>
}