package com.daniel.budgetplanner.onboarding.ui.steps.screen

import androidx.compose.runtime.Composable
import com.daniel.budgetplanner.onboarding.domain.model.StepsData
import com.daniel.budgetplanner.onboarding.presentation.steps.mvi.Onboarding
import com.daniel.budgetplanner.onboarding.ui.steps.view.StepsView

@Composable
fun StepsScreen(
    state: Onboarding.State,
    onClickNextButton: (stepData: StepsData) -> Unit
) {
    when (state) {
        is Onboarding.State.OnboardingStep -> {
            StepsView(
                state = state,
                onNextButtonClick = onClickNextButton
            )
        }
    }
}
