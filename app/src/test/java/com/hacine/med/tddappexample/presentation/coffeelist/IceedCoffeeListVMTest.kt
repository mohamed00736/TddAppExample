package com.hacine.med.tddappexample.presentation.coffeelist

import com.hacine.med.tddappexample.CoroutineRule
import com.hacine.med.tddappexample.FakeUseCaseImpl
import com.hacine.med.tddappexample.data.model.response.Coffee
import com.hacine.med.tddappexample.data.network.state.Resource

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class IceedCoffeeListVMTest{


    private lateinit var viewModel: IceedCoffeeListVM
    private lateinit var fakeUseCase: FakeUseCaseImpl



    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule = CoroutineRule()
    @Before
    fun setUp2() {

        fakeUseCase = FakeUseCaseImpl()

        viewModel = IceedCoffeeListVM(fakeUseCase)
    }

    @Test
    fun `for success resource data must be available`() = runTest {
        val listofCoffe = listOf(
            Coffee("moca","haha", listOf("" ,""),"imgurl" , id = "1" ),
            Coffee("Normal","haha", listOf("" ,""),"imgurl" , id = "2" ),
        )
//        val fakeiiiusecase = FakeUseCaseImpl() // creating fake use case object
//        val viewModel = IceedCoffeeListVM(fakeiiiusecase)  // creating view model object
//        fakeiiiusecase.mimicResponse(Resource.Success(listofCoffe))  // emitting success resource from fake use case
        fakeUseCase.mimicResponse(Resource.Success(listofCoffe))
       // assertThat(viewModel.uistate.value) // comparing if we get in return the correct data

        assertNotNull(viewModel.uiState.value)
        assertEquals(viewModel.uiState.value , UiState.Success(listofCoffe))
    }


    @Test
    fun `for loading resource, uistate  should be Loading `() = runTest {
        fakeUseCase.mimicResponse(Resource.Loading())
     //   assertEquals(viewModel.uiState.value , UiState.Loading)
        assertEquals(UiState.Loading , viewModel.uiState.value)
    }

    @Test
    fun `for error resource, uistate should be Error with message "Error"`() = runTest {
        fakeUseCase.mimicResponse(Resource.Failure(message = "Error"))
        //assertEquals(viewModel.uiState.value , UiState.Error(message = "Error"))
        assertEquals(UiState.Error(message = "Error"), viewModel.uiState.value )
    }


    @Test
    fun`uistate should be success with empty list `() = runTest {
        fakeUseCase.mimicResponse(Resource.Success(emptyList<Coffee>()))
        assertEquals(viewModel.uiState.value , UiState.Success(emptyList<Coffee>()))
    }





    //  private lateinit var repository: CoffeeRepository
//
//    @Mock
//    private lateinit var repository:CoffeeRepository
//    @Mock
//    private lateinit var testApis: CoffeeService
//    @Mock
//    private lateinit var coffedatasource: CoffeeDataSource
//    @Mock
//    private lateinit var Icedusecase: GetIcedCoffeesUseCaseImpl
//
//    private lateinit var mockWebServer: MockWebServer
//
//    private lateinit var repository2: CoffeeRepository
//    private lateinit var testApis2: CoffeeService
//    private lateinit var coffedatasource2: CoffeeDataSource
//    // private lateinit var mockWebServer: MockWebServer

}