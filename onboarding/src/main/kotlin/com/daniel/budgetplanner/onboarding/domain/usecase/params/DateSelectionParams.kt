package com.daniel.budgetplanner.onboarding.domain.usecase.params

import java.time.LocalDate

data class DateSelectionParams(
    val startDate: LocalDate?,
    val endDate: LocalDate?,
    val name: String
)
