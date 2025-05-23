package com.daniel.budgetplanner.onboarding.ui.getstarted.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.daniel.base.ui.theme.BackGround
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.budgetplanner.onboarding.R
import com.daniel.budgetplanner.onboarding.ui.steps.utils.MAX_INPUT

@Composable
fun InputTextField(
    name: String,
    onNameChange: (name: String) -> Unit
) {
    val textFieldValue = remember { mutableStateOf(TextFieldValue(name)) }

    TextField(
        value = textFieldValue.value,
        singleLine = true,
        label = {
            Text(
                text = stringResource(id = R.string.get_started_input_text_placeholder),
                color = Color.Black,
                style = TextStyle(
                    fontSize = 10.sp
                )
            )
        },
        onValueChange = { name ->
            if (name.text.length <= MAX_INPUT) {
                textFieldValue.value = name
                onNameChange(name.text)
            }
        },

        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = BudgetGreen,
            cursorColor = BudgetGreen,
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        )
    )
}

@Preview
@Composable
fun Star() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround)
    ) {
        InputTextField(
            name = "Daniel",
            onNameChange = {}
        )
    }
}
