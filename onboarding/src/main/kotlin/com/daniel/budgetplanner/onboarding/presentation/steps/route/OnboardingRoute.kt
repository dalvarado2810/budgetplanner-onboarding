package com.daniel.budgetplanner.onboarding.presentation.steps.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.daniel.base.utils.extension.CollectEffectWithLifecycle
import com.daniel.budgetplanner.onboarding.presentation.steps.mvi.Onboarding
import com.daniel.budgetplanner.onboarding.presentation.steps.viewmodel.OnboardingViewModel
import com.daniel.budgetplanner.onboarding.ui.steps.screen.StepsScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnboardingRoute(
    viewmodel: OnboardingViewModel = koinViewModel(),
    onNavigateToGetStarted: () -> Unit
) {
    val viewState by viewmodel.state.collectAsStateWithLifecycle()

    CollectEffectWithLifecycle(flow = viewmodel.effect) { effect ->
        when (effect) {
            is Onboarding.Effect.NavigateToGetStarted ->
                onNavigateToGetStarted()
        }
    }

    StepsScreen(
        state = viewState,
        onClickNextButton = viewmodel::clickInNextButton
    )
}
