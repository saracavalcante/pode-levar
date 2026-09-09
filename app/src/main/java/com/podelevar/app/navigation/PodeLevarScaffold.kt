package com.podelevar.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Luggage
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.podelevar.app.R
import com.podelevar.designsystem.components.BottomNavItem
import com.podelevar.designsystem.components.BottomNavigationBar

private val BOTTOM_NAV_ROUTES = setOf(PodeLevarDestinations.HOME, PodeLevarDestinations.SETTINGS)

@Composable
fun PodeLevarScaffold(
    startDestination: String,
    navController: NavHostController = rememberNavController(),
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in BOTTOM_NAV_ROUTES) {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavItem(
                            icon = Icons.Default.Luggage,
                            label = stringResource(R.string.app_bottom_nav_trips_label),
                            selected = currentRoute == PodeLevarDestinations.HOME,
                            onClick = {
                                navController.navigate(PodeLevarDestinations.HOME) {
                                    popUpTo(PodeLevarDestinations.HOME) { inclusive = true }
                                }
                            },
                        ),
                        BottomNavItem(
                            icon = Icons.Default.Settings,
                            label = stringResource(R.string.app_bottom_nav_settings_label),
                            selected = currentRoute == PodeLevarDestinations.SETTINGS,
                            onClick = {
                                navController.navigate(PodeLevarDestinations.SETTINGS) {
                                    popUpTo(PodeLevarDestinations.HOME)
                                }
                            },
                        ),
                    ),
                )
            }
        },
    ) { padding ->
        PodeLevarNavHost(
            startDestination = startDestination,
            navController = navController,
            modifier = Modifier.padding(padding)
        )
    }
}
