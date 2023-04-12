package com.hacine.med.tddappexample.data.source

import com.hacine.med.tddappexample.data.network.api.CoffeeService
import javax.inject.Inject

class CoffeeDataSourceImpl @Inject constructor(
    private val coffeeService: CoffeeService
): CoffeeDataSource {

    override suspend fun getHotCoffees() = coffeeService.getHotCoffees()
    override suspend fun getIcedCoffees() = coffeeService.getIcedCoffees()

}