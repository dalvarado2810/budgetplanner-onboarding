package com.daniel.budgetplanner.onboarding.ui.getstarted.screen

import androidx.compose.runtime.Composable
import com.daniel.budgetplanner.onboarding.presentation.getstarted.mvi.GetStarted
import com.daniel.budgetplanner.onboarding.ui.getstarted.view.GetStartedView
import java.time.LocalDate

@Composable
fun GetStartedScreen(
    state: GetStarted.State,
    onNameChangeAction: (String) -> Unit,
    showPolicyDialogAction: () -> Unit,
    dismissPolicyDialogAction: () -> Unit,
    showDatePickerAction: () -> Unit,
    dismissDatePickerAction: () -> Unit,
    onCheckPolicyAction: (Boolean) -> Unit,
    showErrorDateDialogAction: () -> Unit,
    dismissErrorDateDialogAction: () -> Unit,
    onDateSelectedAction: (LocalDate?, LocalDate?, String) -> Unit,
){
    if (state !is GetStarted.State.Content) return

    GetStartedView(
        state = state,
        onNameChange = onNameChangeAction,
        dateSelectionAction = { start, end, name ->
            onDateSelectedAction(start, end, name)
        },
        showPolicyDialogAction = showPolicyDialogAction,
        dismissPolicyDialogAction = dismissPolicyDialogAction,
        showDatePickerAction = showDatePickerAction,
        dismissDatePickerAction = dismissDatePickerAction,
        onPolicyChecked = onCheckPolicyAction,
        showErrorDateDialogAction = showErrorDateDialogAction,
        dismissErrorDateDialogAction = dismissErrorDateDialogAction
    )
}
