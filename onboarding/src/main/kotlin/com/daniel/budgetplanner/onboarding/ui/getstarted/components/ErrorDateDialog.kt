package com.daniel.budgetplanner.onboarding.ui.getstarted.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorDateDialog(
    onDismissAction: () -> Unit,
){
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    ModalBottomSheet(
        onDismissRequest = {},
        sheetState = bottomSheetState,
    ) {
        DateMissedDialogContent {
            onDismissAction()
        }
    }
}
