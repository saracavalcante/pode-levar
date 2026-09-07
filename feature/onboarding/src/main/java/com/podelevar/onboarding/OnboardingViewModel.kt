package com.podelevar.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.podelevar.common.onboarding.OnboardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class OnboardingUiState(
    val currentPage: Int = 0,
    val totalPages: Int = 3,
    val isCompleted: Boolean = false,
)

sealed interface OnboardingAction {
    data object NextPage : OnboardingAction
    data object PreviousPage : OnboardingAction
    data object Skip : OnboardingAction
}

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val onboardingRepository: OnboardingRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    fun onAction(action: OnboardingAction) {
        when (action) {
            OnboardingAction.NextPage -> {
                val next = _uiState.value.currentPage + 1
                if (next >= _uiState.value.totalPages) complete()
                else _uiState.value = _uiState.value.copy(currentPage = next)
            }
            OnboardingAction.PreviousPage -> {
                val prev = (_uiState.value.currentPage - 1).coerceAtLeast(0)
                _uiState.value = _uiState.value.copy(currentPage = prev)
            }
            OnboardingAction.Skip -> complete()
        }
    }

    private fun complete() {
        viewModelScope.launch { onboardingRepository.setOnboardingCompleted() }
        _uiState.value = _uiState.value.copy(isCompleted = true)
    }
}