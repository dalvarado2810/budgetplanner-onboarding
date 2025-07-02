package com.daniel.budgetplanner.onboarding.presentation.getstarted.mvi

import com.daniel.base.presentation.ViewAction
import com.daniel.base.presentation.ViewEffect
import com.daniel.base.presentation.ViewState
import com.daniel.base.presentation.model.DoNotThrottle
import java.time.LocalDate

object GetStarted {
    sealed class State : ViewState() {
        data class Content(
            val name: String,
            val isPolicyCheck: Boolean,
            val mustErrorDateDialogShown: Boolean,
            val isNextButtonEnabled: Boolean,
            val isPolicyDialogShown: Boolean,
            val isDatePickerShown: Boolean,
        ) : State()
    }

    sealed class Action : ViewAction() {
        @DoNotThrottle
        data class ChangeName(
            val name: String
        ) : Action()

        data class DateSelection(
            val startDate: LocalDate?,
            val endDate: LocalDate?,
            val name: String
        ) : Action()

        data object ShowErrorDateDialog : Action()

        data object DismissErrorDateDialog : Action()

        data object ShowDatePickerDialog : Action()

        data object DismissDatePickerDialog : Action()

        data object ShowPolicyDialog : Action()

        data object DismissPolicyDialog : Action()

        data class ClickOnPolicyCheck(
            val isChecked: Boolean
        ) : Action()
    }

    sealed class Effect : ViewEffect() {
        data object NavigateToDashboard : Effect()
    }
}
