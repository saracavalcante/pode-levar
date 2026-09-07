package com.podelevar.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.podelevar.common.onboarding.OnboardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

sealed interface StartDestination {
    data object Onboarding : StartDestination
    data object Home : StartDestination
}

@HiltViewModel
class AppViewModel @Inject constructor(
    onboardingRepository: OnboardingRepository,
) : ViewModel() {

    val startDestination: StateFlow<StartDestination?> = onboardingRepository.isOnboardingCompleted
        .map { completed -> if (completed) StartDestination.Home else StartDestination.Onboarding }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), initialValue = null)
}