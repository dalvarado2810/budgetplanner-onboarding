package com.daniel.budgetplanner.onboarding.presentation.steps.action

import com.daniel.base.domain.usecase.UseCaseState
import com.daniel.base.presentation.Mutation
import com.daniel.base.presentation.action.ActionProcessor
import com.daniel.budgetplanner.onboarding.domain.model.StepsData
import com.daniel.budgetplanner.onboarding.domain.usecase.NextStepUseCase
import com.daniel.budgetplanner.onboarding.domain.usecase.result.NextStepResult
import com.daniel.budgetplanner.onboarding.presentation.steps.mvi.Onboarding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ClickNextButtonActionProcessor(
    private val nextStepUseCase: NextStepUseCase
) : ActionProcessor<Onboarding.State, Onboarding.Action.ClickNextButton, Onboarding.Effect>() {
    override fun process(
        action: Onboarding.Action.ClickNextButton,
        sideEffect: (Onboarding.Effect) -> Unit
    ): Flow<Mutation<Onboarding.State>> {
        return nextStepUseCase.execute(
            params = action.stepsData
        ).map { useCaseState ->
            when(useCaseState) {
                is UseCaseState.Loading -> { currentState ->
                    currentState
                }

                is UseCaseState.Data -> { currentState ->
                    when (useCaseState.value) {
                        is NextStepResult.NavigateToGetStarted -> {
                            sideEffect(Onboarding.Effect.NavigateToGetStarted)
                            currentState
                        }

                        is NextStepResult.SecondStep ->
                            Onboarding.State.OnboardingStep(
                                stepsData = StepsData.StepTwo
                            )

                        is NextStepResult.ThirdStep ->
                            Onboarding.State.OnboardingStep(
                                stepsData = StepsData.StepThree
                            )
                    }
                }

                is UseCaseState.Error<*, *> -> { currentState ->
                    currentState
                }
            }
        }
    }
}
