package com.daniel.budgetplanner.onboarding.domain.usecase

import com.daniel.base.domain.repository.StorageRepository
import com.daniel.base.domain.usecase.FlowUseCase
import com.daniel.budgetplanner.onboarding.domain.usecase.error.DateSelectionUseCaseError
import com.daniel.budgetplanner.onboarding.domain.usecase.exceptionhandler.DateSelectionExceptionHandler
import com.daniel.budgetplanner.onboarding.domain.usecase.params.DateSelectionParams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class DateSelectionUseCase(
    private val storageRepository: StorageRepository,
    override val exceptionHandler: DateSelectionExceptionHandler
) : FlowUseCase<DateSelectionParams, Unit, DateSelectionUseCaseError>() {
    override suspend fun executeOnBackground(params: DateSelectionParams): Flow<Unit> {
        require(params.startDate != null && params.endDate != null)

        storageRepository.apply {
            setUser(params.name)
            setStartDate(params.startDate.toString())
            setEndDate(params.endDate.toString())
        }

        return flowOf(Unit)
    }
}
