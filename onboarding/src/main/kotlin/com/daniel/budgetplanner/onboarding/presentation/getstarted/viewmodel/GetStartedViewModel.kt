package com.daniel.budgetplanner.onboarding.presentation.getstarted.viewmodel

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.viewmodel.BaseViewModel
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.OnChangeNameActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.mvi.GetStarted
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetStartedViewModel(
    private val onChangeNameActionProcessor: OnChangeNameActionProcessor
) :
BaseViewModel<GetStarted.State, GetStarted.Action, GetStarted.Effect>(
    initialState = GetStarted.State.Content(
        name = "",
        isPolicyCheck = false,
        isPolicyDialogShown = false,
        isNextButtonEnabled = false,
        isDatePickerShown = false,
        mustErrorDateDialogShown = false
    )
) {
    fun dateSelectionAction(
        startDate: LocalDate?,
        endDate: LocalDate?,
        name: String
    ) = sendAction(
            GetStarted.Action.DateSelection(
                startDate = startDate,
                endDate = endDate,
                name = name
            )
        )

    fun onChangeNameAction(name: String) = sendAction(
            GetStarted.Action.ChangeName(
                name = name
            )
        )

    fun showErrorDateDialogAction() = sendAction(GetStarted.Action.ShowErrorDateDialog)

    fun dismissErrorDateDialogAction() = sendAction(GetStarted.Action.DismissErrorDateDialog)

    fun showDatePickerAction() = sendAction(GetStarted.Action.ShowDatePickerDialog)

    fun dismissDatePickerAction() = sendAction(GetStarted.Action.DismissDatePickerDialog)

    fun showPolicyDialogAction() = sendAction(GetStarted.Action.ShowPolicyDialog)

    fun dismissPolicyDialogAction() = sendAction(GetStarted.Action.DismissPolicyDialog)

    fun onCheckPolicyAction(isChecked: Boolean) =
        sendAction(GetStarted.Action.ClickOnPolicyCheck(isChecked))

    override fun processAction(
        action: GetStarted.Action,
        sideEffect: (GetStarted.Effect) -> Unit
    ): Flow<Mutation<GetStarted.State>> {
        return when(action){
            is GetStarted.Action.DateSelection -> TODO()
            is GetStarted.Action.ChangeName -> {
                onChangeNameActionProcessor.process(action, sideEffect)
            }
            is GetStarted.Action.ClickOnPolicyCheck -> TODO()
            is GetStarted.Action.DismissDatePickerDialog -> TODO()
            is GetStarted.Action.DismissErrorDateDialog -> TODO()
            is GetStarted.Action.DismissPolicyDialog -> TODO()
            is GetStarted.Action.ShowDatePickerDialog -> TODO()
            is GetStarted.Action.ShowErrorDateDialog -> TODO()
            is GetStarted.Action.ShowPolicyDialog -> TODO()
        }
    }
}
