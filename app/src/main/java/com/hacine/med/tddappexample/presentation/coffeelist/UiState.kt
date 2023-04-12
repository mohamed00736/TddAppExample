package com.hacine.med.tddappexample.presentation.coffeelist


sealed class UiState  {
    object Loading: UiState()
    data class Success(val data: Any? = null): UiState()
    data class Error(val message: String? = null): UiState()
    data class Fail(val message: String? = null): UiState()
    //data class NotAuthorised(val message: String? = null): UiState()
}