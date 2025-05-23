package com.daniel.budgetplanner.onboarding.presentation.getstarted.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.mvi.GetStarted
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class DismissErrorDateDialogActionProcessor :
    ActionProcessor<GetStarted.State, GetStarted.Action.DismissErrorDateDialog, GetStarted.Effect>() {
    override fun process(
        action: GetStarted.Action.DismissErrorDateDialog,
        sideEffect: (GetStarted.Effect) -> Unit
    ): Flow<Mutation<GetStarted.State>> {
        return flowOf{ currentState ->
            currentState as GetStarted.State.Content

            currentState.copy(
                mustErrorDateDialogShown = false
            )
        }
    }
}
