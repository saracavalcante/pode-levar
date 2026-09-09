package com.podelevar.app.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.podelevar.home.HomeScreen
import com.podelevar.onboarding.OnboardingScreen

@Composable
fun PodeLevarNavHost(
    modifier: Modifier = Modifier,
    startDestination: String,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(PodeLevarDestinations.ONBOARDING) {
            OnboardingScreen(
                onOnboardingFinished = {
                    navController.navigate(PodeLevarDestinations.HOME) {
                        popUpTo(PodeLevarDestinations.ONBOARDING) { inclusive = true }
                    }
                },
            )
        }
        composable(PodeLevarDestinations.HOME) {
            HomeScreen(onCreateTripClick = { })
        }
        composable(PodeLevarDestinations.SETTINGS) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text("Configurações")
            }
        }
    }
}
