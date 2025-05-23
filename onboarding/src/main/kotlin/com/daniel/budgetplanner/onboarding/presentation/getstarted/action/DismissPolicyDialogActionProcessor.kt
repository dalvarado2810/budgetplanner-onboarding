package com.daniel.budgetplanner.onboarding.presentation.getstarted.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.mvi.GetStarted
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class DismissPolicyDialogActionProcessor :
    ActionProcessor<GetStarted.State, GetStarted.Action.DismissPolicyDialog, GetStarted.Effect>() {
    override fun process(
        action: GetStarted.Action.DismissPolicyDialog,
        sideEffect: (GetStarted.Effect) -> Unit
    ): Flow<Mutation<GetStarted.State>> {
        return flowOf { currentState ->
            currentState as GetStarted.State.Content

            currentState.copy(
                isPolicyDialogShown = false
            )
        }
    }
}
