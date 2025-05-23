package com.daniel.budgetplanner.onboarding.domain.usecase.exceptionhandler

import com.daniel.base.domain.usecase.ExceptionHandler
import com.daniel.budgetplanner.onboarding.domain.usecase.error.DateSelectionUseCaseError

class DateSelectionExceptionHandler : ExceptionHandler<DateSelectionUseCaseError>() {
    override fun parseException(throwable: Throwable): DateSelectionUseCaseError? {
        return DateSelectionUseCaseError.NotDateSelected
    }
}
