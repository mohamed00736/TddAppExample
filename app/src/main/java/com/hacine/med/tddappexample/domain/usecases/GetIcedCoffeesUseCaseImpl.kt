package com.hacine.med.tddappexample.domain.usecases


import com.hacine.med.tddappexample.data.model.response.Coffee
import com.hacine.med.tddappexample.data.network.state.Resource
import com.hacine.med.tddappexample.domain.repository.CoffeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class GetIcedCoffeesUseCaseImpl @Inject constructor(
    private val coffeeRepository: CoffeeRepository
) :GetIcedCoffeesUseCase {

//    operator fun invoke(): Flow<Resource<List<Coffee>>> = flow {
//
//        try {
//            emit(Resource.Loading<List<Coffee>>())
//            val coffees = coffeeRepository.getIcedCoffees()
//            emit(Resource.Success<List<Coffee>>(coffees))
//        } catch (e: Exception){
//            emit(Resource.Failure<List<Coffee>>(e.localizedMessage ?: "An unexpected error occurred"))
//        }
//
//    }.flowOn(Dispatchers.IO)

    override fun getIcedCoffe() = flow {
        try {
            emit(Resource.Loading<List<Coffee>>())
            val coffees = coffeeRepository.getIcedCoffees()
            emit(Resource.Success<List<Coffee>>(coffees))
        } catch (e: Exception) {
            emit(
                Resource.Failure<List<Coffee>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        }
    }.flowOn(Dispatchers.IO)
}