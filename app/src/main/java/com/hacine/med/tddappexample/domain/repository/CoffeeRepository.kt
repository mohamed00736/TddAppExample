package com.hacine.med.tddappexample.domain.repository

import com.hacine.med.tddappexample.data.model.response.Coffee


interface CoffeeRepository {

    suspend fun getHotCoffees(): List<Coffee>
    suspend fun getIcedCoffees(): List<Coffee>

}