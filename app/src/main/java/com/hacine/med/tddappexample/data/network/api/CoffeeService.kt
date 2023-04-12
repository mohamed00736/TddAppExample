package com.hacine.med.tddappexample.data.network.api


import com.hacine.med.tddappexample.data.model.response.Coffee
import com.hacine.med.tddappexample.util.Constants.HOT_COFFEES_ENDPOINT
import com.hacine.med.tddappexample.util.Constants.ICED_COFFEES_ENDPOINT
import retrofit2.http.GET

interface CoffeeService {

    @GET(HOT_COFFEES_ENDPOINT)
    suspend fun getHotCoffees(): List<Coffee>

    @GET(ICED_COFFEES_ENDPOINT)
    suspend fun getIcedCoffees(): List<Coffee>

}