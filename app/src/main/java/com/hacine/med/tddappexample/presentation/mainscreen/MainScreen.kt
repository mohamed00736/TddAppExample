package app.selcukokc.coffeeguide.presentation.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.hacine.med.tddappexample.navigation.BottomNav
import com.hacine.med.tddappexample.navigation.NavGraph


@Composable
fun MainScreen(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNav(navController = navController)
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            NavGraph(navController = navController)
        }
    }

}

