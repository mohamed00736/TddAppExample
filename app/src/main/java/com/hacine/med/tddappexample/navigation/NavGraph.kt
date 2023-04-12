package com.hacine.med.tddappexample.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hacine.med.tddappexample.presentation.coffeelist.CoffeeListScreen
import com.hacine.med.tddappexample.presentation.coffeelist.HootCoffeeListVM
import com.hacine.med.tddappexample.presentation.coffeelist.IceedCoffeeListVM


@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.HotCoffees.route
    ){
        composable(route = Screen.HotCoffees.route){
            val viewModel: IceedCoffeeListVM = hiltViewModel()
            CoffeeListScreen(viewModel)
        }

        composable(route = Screen.IcedCoffees.route){
            val viewModel: HootCoffeeListVM = hiltViewModel()
            CoffeeListScreen(viewModel)
        }
    }
}