package com.daniel.budgetplanner.onboarding.presentation.getstarted.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.daniel.base.utils.extension.CollectEffectWithLifecycle
import com.daniel.budgetplanner.onboarding.presentation.getstarted.mvi.GetStarted
import com.daniel.budgetplanner.onboarding.presentation.getstarted.viewmodel.GetStartedViewModel
import com.daniel.budgetplanner.onboarding.ui.getstarted.screen.GetStartedScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun GetStartedRoute(
    viewModel: GetStartedViewModel = koinViewModel(),
    onNavigateToDashboard: () -> Unit
) {
    val viewState by viewModel.state.collectAsStateWithLifecycle()

    CollectEffectWithLifecycle(flow = viewModel.effect) { effect ->
        when(effect) {
            is GetStarted.Effect.NavigateToDashboard -> onNavigateToDashboard()
        }
    }

    GetStartedScreen(
        state = viewState,
        onNameChangeAction = viewModel::onChangeNameAction,
        showErrorDateDialogAction = {},
        dismissErrorDateDialogAction = {},
        showDatePickerAction = {},
        dismissDatePickerAction = {},
        showPolicyDialogAction = {},
        dismissPolicyDialogAction = {},
        onCheckPolicyAction = {},
        onDateSelectedAction = {start, end, name ->
            viewModel.dateSelectionAction(
                startDate = start,
                endDate = end,
                name = name
            )
        }
    )
}
