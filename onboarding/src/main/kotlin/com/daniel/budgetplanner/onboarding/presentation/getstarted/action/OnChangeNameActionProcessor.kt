package com.daniel.budgetplanner.onboarding.presentation.getstarted.action

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.mvi.GetStarted
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class OnChangeNameActionProcessor :
    ActionProcessor<GetStarted.State, GetStarted.Action.ChangeName, GetStarted.Effect>() {
    override fun process(
        action: GetStarted.Action.ChangeName,
        sideEffect: (GetStarted.Effect) -> Unit
    ): Flow<Mutation<GetStarted.State>> {
        return flowOf { currentState ->
            if (currentState is GetStarted.State.Content) {
                currentState.copy(
                    name = action.name
                )
            } else {
                currentState
            }
        }
    }
}
