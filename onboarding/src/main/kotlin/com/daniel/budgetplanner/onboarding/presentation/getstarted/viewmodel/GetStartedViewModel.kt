package com.daniel.budgetplanner.onboarding.presentation.getstarted.viewmodel

import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.viewmodel.BaseViewModel
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.DateSelectionActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.DismissDatePickerActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.DismissErrorDateDialogActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.DismissPolicyDialogActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.OnChangeNameActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.OnPolicyCheckActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.ShowDatePickerActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.ShowErrorDateDialogActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.ShowPolicyDialogActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.mvi.GetStarted
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetStartedViewModel(
    private val dateSelectionActionProcessor: DateSelectionActionProcessor,
    private val onChangeNameActionProcessor: OnChangeNameActionProcessor,
    private val onPolicyCheckActionProcessor: OnPolicyCheckActionProcessor,
    private val showDatePickerActionProcessor: ShowDatePickerActionProcessor,
    private val dismissDatePickerActionProcessor: DismissDatePickerActionProcessor,
    private val showErrorDateDialogActionProcessor: ShowErrorDateDialogActionProcessor,
    private val dismissErrorDateDialogActionProcessor: DismissErrorDateDialogActionProcessor,
    private val showPolicyDialogActionProcessor: ShowPolicyDialogActionProcessor,
    private val dismissPolicyDialogActionProcessor: DismissPolicyDialogActionProcessor
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
            is GetStarted.Action.DateSelection -> {
                dateSelectionActionProcessor.process(action, sideEffect)
            }
            is GetStarted.Action.ChangeName -> {
                onChangeNameActionProcessor.process(action, sideEffect)
            }
            is GetStarted.Action.ClickOnPolicyCheck -> {
                onPolicyCheckActionProcessor.process(action, sideEffect)
            }
            is GetStarted.Action.DismissDatePickerDialog -> {
                dismissDatePickerActionProcessor.process(action, sideEffect)
            }
            is GetStarted.Action.DismissErrorDateDialog -> {
                dismissErrorDateDialogActionProcessor.process(action, sideEffect)
            }
            is GetStarted.Action.DismissPolicyDialog -> {
                dismissPolicyDialogActionProcessor.process(action, sideEffect)
            }
            is GetStarted.Action.ShowDatePickerDialog -> {
                showDatePickerActionProcessor.process(action, sideEffect)
            }
            is GetStarted.Action.ShowErrorDateDialog -> {
                showErrorDateDialogActionProcessor.process(action, sideEffect)
            }
            is GetStarted.Action.ShowPolicyDialog -> {
                showPolicyDialogActionProcessor.process(action, sideEffect)
            }
        }
    }
}
