package com.daniel.budgetplanner.onboarding.di

import com.daniel.budgetplanner.onboarding.domain.usecase.DateSelectionUseCase
import com.daniel.budgetplanner.onboarding.domain.usecase.NextStepUseCase
import com.daniel.budgetplanner.onboarding.domain.usecase.exceptionhandler.DateSelectionExceptionHandler
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.DateSelectionActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.DismissDatePickerActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.DismissErrorDateDialogActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.DismissPolicyDialogActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.OnChangeNameActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.OnPolicyCheckActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.ShowDatePickerActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.ShowErrorDateDialogActionProcessor
import com.daniel.budgetplanner.onboarding.presentation.getstarted.action.ShowPolicyDialogActionProcessor
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
    factoryOf(::OnPolicyCheckActionProcessor)
    factoryOf(::ShowDatePickerActionProcessor)
    factoryOf(::DismissDatePickerActionProcessor)
    factoryOf(::DateSelectionActionProcessor)
    factoryOf(::ShowErrorDateDialogActionProcessor)
    factoryOf(::DismissErrorDateDialogActionProcessor)
    factoryOf(::ShowPolicyDialogActionProcessor)
    factoryOf(::DismissPolicyDialogActionProcessor)

    // Use Cases
    factoryOf(::NextStepUseCase)
    factoryOf(::DateSelectionUseCase)

    // Exception Handler
    factoryOf(::DateSelectionExceptionHandler)
}
