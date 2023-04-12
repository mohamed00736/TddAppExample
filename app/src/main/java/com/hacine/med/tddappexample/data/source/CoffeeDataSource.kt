package com.hacine.med.tddappexample.data.source

import com.hacine.med.tddappexample.data.model.response.Coffee


interface CoffeeDataSource {
    suspend fun getHotCoffees(): List<Coffee>
    suspend fun getIcedCoffees(): List<Coffee>
}