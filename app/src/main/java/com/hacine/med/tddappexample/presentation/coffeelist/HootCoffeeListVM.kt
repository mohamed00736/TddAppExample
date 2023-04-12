package com.hacine.med.tddappexample.presentation.coffeelist

import androidx.lifecycle.viewModelScope
import com.hacine.med.tddappexample.data.network.state.Resource
import com.hacine.med.tddappexample.domain.usecases.GetHotCoffeesUseCase
import com.hacine.med.tddappexample.presentation.base.BaseViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HootCoffeeListVM @Inject constructor(
    private val getHotCoffeesUseCaseImpl: GetHotCoffeesUseCase,

    ): BaseViewModel<UiState>() {


    init {
        //_uiState.value = UiState.Loading
        getIcedCoffees()
    }
    private fun getIcedCoffees(){
        viewModelScope.launch {
            getHotCoffeesUseCaseImpl.getHotCoffee().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.value = UiState.Loading
                    }

                    is Resource.Success -> {
                        _uiState.value = UiState.Success(result.data)
                    }

                    is Resource.Failure -> {
                        _uiState.value = UiState.Error(result.message)
                    }
                }

            }
        }

//        getHotCoffeesUseCaseImpl().onEach { result->
//            when(result) {
//                is Resource.Success -> {
//                    _uistate.value = UiState.Success(result.data)
//                    //setState(CoffeeListState(coffees = result.data ?: emptyList()))
//                }
//
//                is Resource.Failure -> {
//                    _uistate.value =UiState.Error(result.message)
//                    //setState(CoffeeListState(error = result.message ?: "An unexpected error occurred"))
//                }
//                else -> {}
//            }
//        }.launchIn(viewModelScope)

    }

}