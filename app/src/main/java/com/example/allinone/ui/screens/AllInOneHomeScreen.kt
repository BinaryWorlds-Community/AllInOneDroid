package com.example.allinone.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.allinone.ui.components.IconWithTitle

@Composable
fun AllInOneHomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val navItems = listOf(
            NavigationItemContent.recipes,
            NavigationItemContent.shopping,
            NavigationItemContent.storage,
            NavigationItemContent.settings,
        )

        for (navItem in navItems) {
            IconWithTitle(
                title = navItem.iconTitle,
                iconRes = navItem.iconRes,
                onClickListener = { navController.navigate(navItem.iconRoute.toString()) }
            )
        }
    }
}



