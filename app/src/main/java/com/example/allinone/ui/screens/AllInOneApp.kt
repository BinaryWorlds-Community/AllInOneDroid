package com.example.allinone.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.allinone.App
import com.example.allinone.R
import com.example.allinone.ui.AllInOneSettingsScreen
import com.example.allinone.ui.viewmodel.AllInOneViewModel
import com.example.allinone.ui.viewmodel.viewModelFactory

sealed class NavigationItemContent(
    @DrawableRes val iconRes: Int,
    @StringRes val iconTitle: Int,
    val iconRoute: String?
) {
    object home : NavigationItemContent(
        iconRes = R.drawable.home,
        iconTitle = R.string.home,
        iconRoute = "/home"
    )
    object recipes : NavigationItemContent(
        iconRes = R.drawable.recipes,
        iconTitle = R.string.recipes,
        iconRoute = "/recipes"
    )
    object shopping : NavigationItemContent(
        iconRes = R.drawable.shopping,
        iconTitle = R.string.shopping_list,
        iconRoute = App.appResources?.getString(R.string.shopping_list)
    )
    object settings : NavigationItemContent(
        iconRes = R.drawable.settings,
        iconTitle = R.string.settings,
        iconRoute = "/settings"
    )
    object storage : NavigationItemContent(
        iconRes = R.drawable.storage,
        iconTitle = R.string.storage,
        iconRoute = "/storage"
    )
}

@Composable
fun AllInOneApp (
    modifier: Modifier = Modifier,
    viewModel: AllInOneViewModel = viewModel<AllInOneViewModel>(
        factory = viewModelFactory {
            AllInOneViewModel(App.appModule)
        }
    ),
    navController: NavHostController = rememberNavController()
){
    var isNotHomeScreen by remember { mutableStateOf(false)}
    val backStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            if(isNotHomeScreen)
                BottomNavigationBar(
                    navController = navController,
                )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = NavigationItemContent.home.iconRoute.toString(),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            composable(route = NavigationItemContent.home.iconRoute.toString()){
                isNotHomeScreen = false
                AllInOneHomeScreen(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable(route = NavigationItemContent.recipes.iconRoute.toString()){
                isNotHomeScreen = true
                AllInOneRecipeScreen(
                    modifier = modifier
                )
            }

            composable(route = NavigationItemContent.shopping.iconRoute.toString()){
                isNotHomeScreen = true
                AllInOneShoppingScreen(
                    modifier = modifier,
                    onHomeButtonClicked = { navController.navigate(NavigationItemContent.home.iconRoute.toString())}
                )
            }

            composable(route = NavigationItemContent.storage.iconRoute.toString()){
                isNotHomeScreen = true
                AllInOneStorageScreen(
                    modifier = modifier,
                )
            }

            composable(route = NavigationItemContent.settings.iconRoute.toString()){
                isNotHomeScreen = true
                AllInOneSettingsScreen(
                    modifier = modifier,
                    uiState = viewModel.uiState.collectAsState().value,
                    selectDarkMode = viewModel::selectDarkMode
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavController,
) {
    val navItems = listOf(
        NavigationItemContent.home,
        NavigationItemContent.recipes,
        NavigationItemContent.shopping,
        NavigationItemContent.storage,
        NavigationItemContent.settings,
    )
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        for (navItem in navItems) {
            NavigationBarItem(
                selected = currentRoute == navItem.iconRoute.toString(),
                onClick = { navController.navigate(navItem.iconRoute.toString()) },
                icon = { Icon(painterResource(navItem.iconRes), contentDescription = stringResource(navItem.iconTitle)) },
            )
        }
    }
}
