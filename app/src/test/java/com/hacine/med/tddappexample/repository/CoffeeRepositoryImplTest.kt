package com.hacine.med.tddappexample.data.repository


import com.google.gson.Gson
import com.hacine.med.tddappexample.data.model.response.Coffee
import com.hacine.med.tddappexample.data.network.api.CoffeeService
import com.hacine.med.tddappexample.data.source.CoffeeDataSource
import com.hacine.med.tddappexample.data.source.CoffeeDataSourceImpl
import com.hacine.med.tddappexample.domain.repository.CoffeeRepository
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class CoffeeRepositoryImplTest{
    private lateinit var repository: CoffeeRepository
    private lateinit var coffeeService: CoffeeService
    private lateinit var coffedatasource: CoffeeDataSource
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        var BASE_URL = mockWebServer.url("/").toString()
        val okHttpClient = OkHttpClient
            .Builder()
            .build()
        val service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build().create(CoffeeService::class.java)
        coffeeService = service
        coffedatasource = CoffeeDataSourceImpl(coffeeService)
        repository = CoffeeRepositoryImpl(coffedatasource)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `for multiple coffee  items , api must return all coffee items  with http code 200`() = runTest {
        val listofCoffe = listOf(
            Coffee("Mocha","haha", listOf("" ,""),"imgurl" , id = "1" ),
            Coffee("Normal Coffe","haha", listOf("" ,""),"imgurl" , id = "2" ),
        )
        val expectedResponse = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(Gson().toJson(listofCoffe))
        mockWebServer.enqueue(expectedResponse)

        val actualResponse = repository.getIcedCoffees()

         assertEquals(actualResponse.size , listofCoffe.size)
         assertEquals(actualResponse.get(0) , listofCoffe.get(0))
    }
}