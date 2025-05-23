package com.daniel.budgetplanner.onboarding.di

import com.daniel.budgetplanner.onboarding.domain.usecase.NextStepUseCase
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.OnChangeNameActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.viewmodel.GetStartedViewModel
import com.daniel.budgetplanner.onboarding.presentation.steps.action.ClickNextButtonActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.steps.viewmodel.OnboardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val onboardingModule = module {
    // ViewModel
    viewModelOf(::OnboardingViewModel)
    viewModelOf(::GetStartedViewModel)

    // Action Processor
    factoryOf(::ClickNextButtonActionProcessor)
    factoryOf(::OnChangeNameActionProcessor)

    // Use Cases
    factoryOf(::NextStepUseCase)
}
