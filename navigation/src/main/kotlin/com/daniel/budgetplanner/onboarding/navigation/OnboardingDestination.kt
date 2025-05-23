package com.daniel.budgetplanner.onboarding.navigation

import com.daniel.base.presentation.model.Destination
import kotlinx.serialization.Serializable

@Serializable
sealed class OnboardingDestination : Destination() {
    @Serializable
    data object NavGraph : OnboardingDestination()

    @Serializable
    data object Onboarding : OnboardingDestination()

    @Serializable
    data object GetStarted : OnboardingDestination()
}