package com.podelevar.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.podelevar.app.navigation.PodeLevarDestinations
import com.podelevar.app.navigation.PodeLevarScaffold
import com.podelevar.app.ui.AppViewModel
import com.podelevar.app.ui.StartDestination
import com.podelevar.designsystem.theme.PodeLevarTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val appViewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PodeLevarTheme {
                val startDestination by appViewModel.startDestination.collectAsStateWithLifecycle()
                when (val destination = startDestination) {
                    null -> Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background),
                    )

                    else -> PodeLevarScaffold(
                        startDestination = when (destination) {
                            StartDestination.Onboarding -> PodeLevarDestinations.ONBOARDING
                            StartDestination.Home -> PodeLevarDestinations.HOME
                        }
                    )
                }
            }
        }
    }
}
