package com.daniel.budgetplanner.onboarding.presentation.steps.viewmodel

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.viewmodel.BaseViewModel
import com.daniel.budgetplanner.onboarding.domain.model.StepsData
import com.daniel.budgetplanner.onboarding.presentation.steps.action.ClickNextButtonActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.steps.mvi.Onboarding
import kotlinx.coroutines.flow.Flow

class OnboardingViewModel(
    private val clickNextButtonActionProcessor: ClickNextButtonActionProcessor
) : BaseViewModel<Onboarding.State, Onboarding.Action, Onboarding.Effect>(
    initialState = Onboarding.State.OnboardingStep(
        stepsData = StepsData.StepOne)
) {
    fun clickInNextButton(stepData: StepsData) =
        sendAction(Onboarding.Action.ClickNextButton(stepsData = stepData))

    override fun processAction(
        action: Onboarding.Action,
        sideEffect: (Onboarding.Effect) -> Unit
    ): Flow<Mutation<Onboarding.State>> {
        return when(action) {
            is Onboarding.Action.ClickNextButton ->
                clickNextButtonActionProcessor.process(action, sideEffect)
        }
    }
}
