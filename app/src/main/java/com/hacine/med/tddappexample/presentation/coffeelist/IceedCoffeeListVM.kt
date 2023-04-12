package com.hacine.med.tddappexample.presentation.coffeelist

import androidx.lifecycle.viewModelScope
import com.hacine.med.tddappexample.data.network.state.Resource
import com.hacine.med.tddappexample.domain.usecases.GetIcedCoffeesUseCase
import com.hacine.med.tddappexample.presentation.base.BaseViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IceedCoffeeListVM @Inject constructor(
    private val geticedCoffeesUseCase: GetIcedCoffeesUseCase,
): BaseViewModel<UiState>(){

    init {
        getHotCoffees()
    }
      private fun getHotCoffees(){
         viewModelScope.launch {
             geticedCoffeesUseCase.getIcedCoffe().collect { result ->
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


//        geticedCoffeesUseCase2Impl().onEach { result->
//
//            when(result) {
//                is Resource.Loading -> {
//                    _uistate.value = UiState.Loading
//                }
//
//                is Resource.Success -> {
//                    _uistate.value = UiState.Success(result.data)
//                }
//
//                is Resource.Failure -> {
//                    _uistate.value =UiState.Error(result.message)
//                }
//            }
//
//        }.launchIn(viewModelScope)

    }



}