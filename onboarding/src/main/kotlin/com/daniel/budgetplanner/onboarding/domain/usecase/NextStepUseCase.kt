package com.daniel.budgetplanner.onboarding.domain.usecase

import com.daniel.base.domain.usecase.FlowUseCase
import com.daniel.budgetplanner.onboarding.domain.model.StepsData
import com.daniel.budgetplanner.onboarding.domain.usecase.result.NextStepResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class NextStepUseCase : FlowUseCase<StepsData, NextStepResult, Nothing>() {
    override suspend fun executeOnBackground(params: StepsData): Flow<NextStepResult> {
        return when(params) {
            is StepsData.StepOne -> {
                flowOf(NextStepResult.SecondStep)
            }
            is StepsData.StepThree -> {
                flowOf(NextStepResult.NavigateToGetStarted)
            }
            is StepsData.StepTwo -> {
                flowOf(NextStepResult.ThirdStep)
            }
        }
    }
}
