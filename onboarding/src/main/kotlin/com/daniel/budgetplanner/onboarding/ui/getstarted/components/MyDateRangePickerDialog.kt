package com.daniel.budgetplanner.onboarding.ui.getstarted.components

import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.daniel.budgetplanner.onboarding.ui.steps.utils.convertMillisToDate
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDateRangePickerDialog(
    onDismiss: () -> Unit,
    onRangeDatesSelected: (LocalDate?, LocalDate?) -> Unit
) {
    val dateRangePickerState = rememberDateRangePickerState(
        initialSelectedStartDateMillis = System.currentTimeMillis(),
        initialSelectedEndDateMillis = System.currentTimeMillis()
    )

    val selectedStarDate = dateRangePickerState.selectedStartDateMillis?.let {
        convertMillisToDate(it)
    }

    val selectedEndDate = dateRangePickerState.selectedEndDateMillis?.let {
        convertMillisToDate(it)
    }

    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(onClick = {
                val endDate = selectedEndDate ?: selectedStarDate
                onRangeDatesSelected(
                    selectedStarDate,
                    endDate
                )
                onDismiss()
            }
            ) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            Button(onClick = {
                onDismiss()
            }) {
                Text(text = "Cancel")
            }
        }
    ) {
        MyDateRangePicker(state = dateRangePickerState)
    }
}

@Composable
@Preview
fun MyDateRangePreview(){
    MyDateRangePickerDialog(
        onRangeDatesSelected = {start, end -> },
        onDismiss = {}
    )
}
