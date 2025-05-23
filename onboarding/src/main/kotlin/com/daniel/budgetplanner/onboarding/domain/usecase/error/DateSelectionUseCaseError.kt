package com.daniel.budgetplanner.onboarding.domain.usecase.error

import com.daniel.base.domain.usecase.UseCaseError

sealed interface DateSelectionUseCaseError : UseCaseError {
    data object NotDateSelected : DateSelectionUseCaseError
}
