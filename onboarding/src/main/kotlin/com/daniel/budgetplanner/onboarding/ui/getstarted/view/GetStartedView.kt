package com.daniel.budgetplanner.onboarding.ui.getstarted.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniel.base.ui.theme.BackGround
import com.daniel.budgetplanner.onboarding.R
import com.daniel.budgetplanner.onboarding.presentation.getstarted.mvi.GetStarted
import com.daniel.budgetplanner.onboarding.ui.getstarted.components.ContinueButton
import com.daniel.budgetplanner.onboarding.ui.getstarted.components.DefaultTopShape
import com.daniel.budgetplanner.onboarding.ui.getstarted.components.ErrorDateDialog
import com.daniel.budgetplanner.onboarding.ui.getstarted.components.GetStartedContent
import com.daniel.budgetplanner.onboarding.ui.getstarted.components.GetStartedTopInputComponent
import com.daniel.budgetplanner.onboarding.ui.getstarted.components.PolicyDialog
import com.daniel.budgetplanner.onboarding.ui.steps.utils.STRING_SPACE
import com.daniel.budgetplanner.onboarding.ui.getstarted.components.MyDateRangePickerDialog
import java.time.LocalDate

@Composable
fun GetStartedView (
    state: GetStarted.State.Content,
    onNameChange: (String) -> Unit,
    dateSelectionAction: (LocalDate?, LocalDate?, String) -> Unit,
    onPolicyChecked: (Boolean) -> Unit,
    showPolicyDialogAction: () -> Unit,
    dismissPolicyDialogAction: () -> Unit,
    showErrorDateDialogAction: () -> Unit,
    dismissErrorDateDialogAction: () -> Unit,
    showDatePickerAction: () -> Unit,
    dismissDatePickerAction: () -> Unit
) {
    val clickableText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Black)) {
            append(stringResource(id = R.string.get_started_agree))
            append(STRING_SPACE)
        }
        withLink(
            link = LinkAnnotation.Clickable(
                tag = "link",
                styles = TextLinkStyles(
                    style = SpanStyle(
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline)
                )
            ) {
                showPolicyDialogAction()
            }
        ) {
            append(stringResource(id = R.string.get_started_privacy_policy))
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackGround)
    ) {
        DefaultTopShape()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GetStartedTopInputComponent(
                name = state.name,
                onNameChange = onNameChange
            )

            GetStartedContent(
                isPolicyCheck = state.isPolicyCheck,
                clickableText = clickableText,
                onPolicyChecked = onPolicyChecked
            )

            Spacer(modifier = Modifier.weight(1f))

            ContinueButton(
                enabled = state.isPolicyCheck && state.name.isNotEmpty(),
                text = stringResource(id = R.string.get_started_lets_begin)
            ) {
                showDatePickerAction()
            }
        }

        if (state.isPolicyDialogShown){
            PolicyDialog(
                onDismiss = dismissPolicyDialogAction
            )
        }

        if (state.isDatePickerShown) {
            MyDateRangePickerDialog(
                onRangeDatesSelected = { star, end ->
                    if (star == end) {
                        showErrorDateDialogAction()
                    } else {
                        dateSelectionAction(star, end, state.name)
                    }
                },
                onDismiss = {
                    dismissDatePickerAction()
                }
            )
        }

        if (state.mustErrorDateDialogShown) {
            ErrorDateDialog {
                dismissErrorDateDialogAction()
            }
        }
    }
}

@Preview
@Composable
fun GetStartedViewPreview(){
    GetStartedView (
        state = GetStarted.State.Content(
            name = "Daniel",
            isPolicyCheck = true,
            isNextButtonEnabled = false,
            isPolicyDialogShown = false,
            isDatePickerShown = false,
            mustErrorDateDialogShown = true
        ),
        onNameChange = { },
        dateSelectionAction = { start, end , name -> },
        dismissDatePickerAction = {},
        showDatePickerAction = {},
        dismissPolicyDialogAction = {},
        showPolicyDialogAction = {},
        onPolicyChecked = {},
        showErrorDateDialogAction = {},
        dismissErrorDateDialogAction = {}
    )
}
