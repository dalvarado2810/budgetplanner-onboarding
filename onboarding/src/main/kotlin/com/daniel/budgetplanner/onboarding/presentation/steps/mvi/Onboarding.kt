package com.daniel.budgetplanner.onboarding.presentation.steps.mvi

import com.daniel.base.presentation.ViewAction
import com.daniel.base.presentation.ViewEffect
import com.daniel.base.presentation.ViewState
import com.daniel.budgetplanner.onboarding.domain.model.StepsData

object Onboarding {
    sealed class State : ViewState() {
        data class OnboardingStep(
            val stepsData: StepsData
        ) : State()
    }

    sealed class Action : ViewAction() {
        data class ClickNextButton(
            val stepsData: StepsData
        ) : Action()
    }

    sealed class Effect : ViewEffect() {
        data object NavigateToGetStarted : Effect()
    }
}
