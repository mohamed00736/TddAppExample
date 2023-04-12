package com.hacine.med.tddappexample.navigation

import com.hacine.med.tddappexample.R


sealed class Screen(
    val route: String,
    val title: String,
    val icon: Int
){
    object HotCoffees: Screen(
        route = "icedcoffees",
        title = "Iced Coffees",
        icon = R.drawable.ic_baseline_coffee_24
    )

    object IcedCoffees: Screen(
        route = "hotcoffees",
        title = "Hot Coffees",
        icon = R.drawable.ic_baseline_coffee_24
    )
}