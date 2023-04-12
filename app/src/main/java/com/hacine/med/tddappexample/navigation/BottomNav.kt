package com.hacine.med.tddappexample.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hacine.med.tddappexample.presentation.ui.theme.Brown
import com.hacine.med.tddappexample.util.AddItem


@Composable
fun BottomNav(navController: NavHostController) {
    val screens = listOf(
        Screen.HotCoffees,
        Screen.IcedCoffees,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = Brown,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp, 12.dp, 0.dp, 0.dp))
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}