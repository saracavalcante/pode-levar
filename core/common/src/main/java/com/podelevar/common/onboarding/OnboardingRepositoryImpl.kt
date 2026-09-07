package com.podelevar.common.onboarding

import kotlinx.coroutines.flow.Flow

interface OnboardingRepository {
    val isOnboardingCompleted: Flow<Boolean>
    suspend fun setOnboardingCompleted()
}