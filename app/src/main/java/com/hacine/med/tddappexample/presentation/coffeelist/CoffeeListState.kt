package com.hacine.med.tddappexample.presentation.coffeelist

import com.hacine.med.tddappexample.data.model.response.Coffee
import com.hacine.med.tddappexample.presentation.base.IViewState


data class CoffeeListState(
    val isLoading: Boolean = false,
    val coffees: List<Coffee>? = emptyList(),
    val error: String = ""
): IViewState