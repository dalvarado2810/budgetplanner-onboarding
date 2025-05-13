package com.daniel.budgetplanner.onboarding.domain.usecase.result

sealed interface NextStepResult {
    data object SecondStep : NextStepResult
    data object ThirdStep : NextStepResult
    data object NavigateToGetStarted : NextStepResult
}
