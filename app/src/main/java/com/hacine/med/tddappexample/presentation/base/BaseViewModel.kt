package com.hacine.med.tddappexample.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<T>: ViewModel() {

    protected val _uiState: MutableStateFlow<T?> = MutableStateFlow(null)
    val uiState: StateFlow<T?> get() = _uiState


}