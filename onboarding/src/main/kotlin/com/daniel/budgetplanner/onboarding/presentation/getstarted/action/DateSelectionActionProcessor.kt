package com.daniel.budgetplanner.onboarding.presentation.getstarted.action

import com.daniel.base.domain.usecase.UseCaseState
import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.onboarding.domain.usecase.DateSelectionUseCase
import com.daniel.budgetplanner.onboarding.domain.usecase.error.DateSelectionUseCaseError
import com.daniel.budgetplanner.onboarding.domain.usecase.params.DateSelectionParams
import com.daniel.budgetplanner.onboarding.presentation.getstarted.mvi.GetStarted
import com.daniel.budgetplanner.onboarding.ui.steps.utils.EFFECT_DELAY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DateSelectionActionProcessor(
    private val dateSelectionUseCase: DateSelectionUseCase
) : ActionProcessor<GetStarted.State, GetStarted.Action.DateSelection, GetStarted.Effect>() {
    override fun process(
        action: GetStarted.Action.DateSelection,
        sideEffect: (GetStarted.Effect) -> Unit
    ): Flow<Mutation<GetStarted.State>> {
        return dateSelectionUseCase.execute(
            params = DateSelectionParams(
                startDate = action.startDate,
                endDate = action.endDate,
                name = action.name
            )
        ).map { useCaseState ->
            when(useCaseState) {
                is UseCaseState.Data -> { currentState ->
                    currentState as GetStarted.State.Content
                    CoroutineScope(Dispatchers.IO).launch {
                        delay(EFFECT_DELAY)
                        sideEffect(GetStarted.Effect.NavigateToDashboard)
                    }

                    currentState.copy(
                        isDatePickerShown = false
                    )
                }
                is UseCaseState.Error -> { currentState ->
                    require(currentState is GetStarted.State.Content)
                    when (useCaseState.error){
                        DateSelectionUseCaseError.NotDateSelected -> {
                            currentState.copy(
                                mustErrorDateDialogShown = true,
                                isDatePickerShown = false
                            )
                        }
                        null -> currentState
                    }
                }
                is UseCaseState.Loading -> { currentState ->
                    currentState
                }
            }
        }
    }
}
