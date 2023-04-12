package com.hacine.med.tddappexample.data.repository


import com.hacine.med.tddappexample.data.source.CoffeeDataSource
import com.hacine.med.tddappexample.domain.repository.CoffeeRepository
import javax.inject.Inject

class CoffeeRepositoryImpl @Inject constructor(
    private val coffeeDataSource: CoffeeDataSource,
): CoffeeRepository {

    override suspend fun getHotCoffees() = coffeeDataSource.getHotCoffees()
    override suspend fun getIcedCoffees() = coffeeDataSource.getIcedCoffees()

}