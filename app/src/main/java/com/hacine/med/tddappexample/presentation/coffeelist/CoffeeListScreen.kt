package com.hacine.med.tddappexample.presentation.coffeelist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import com.hacine.med.tddappexample.data.model.response.Coffee
import com.hacine.med.tddappexample.presentation.base.BaseViewModel
import com.hacine.med.tddappexample.presentation.components.CoffeeItem

@Composable
fun CoffeeListScreen(viewModel: BaseViewModel<UiState>){

 //   val state = viewModel.viewState.value
    // Hot coffee view model
    val uiStat = viewModel.uiState.collectAsState()

    when(val data = uiStat.value){

       is  UiState.Loading ->{
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(modifier =  Modifier.align(Alignment.Center))
        }
       }

       is  UiState.Success ->{
           LazyColumn{
               items(data.data as List<Coffee> ?: listOf<Coffee>()){ coffee ->
                   CoffeeItem(coffee = coffee)
               }
           }
        }
        is UiState.Error ->{
        Text(
            text = data.message.toString(),
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        }
    }

//    if(state.isLoading){
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//        }
//    }

//    if(state.error.isNotBlank()) {
//        Text(
//            text = state.error,
//            color = MaterialTheme.colors.error,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp)
//        )
//    }

//    LazyColumn{
//        items(state.coffees ?: listOf()){ coffee ->
//            CoffeeItem(coffee = coffee)
//        }
//    }


}