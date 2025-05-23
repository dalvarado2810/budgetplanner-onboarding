package com.daniel.budgetplanner.onboarding.ui.getstarted.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniel.base.ui.theme.fonts
import com.daniel.budgetplanner.onboarding.R

@Composable
fun GetStartedTopInputComponent(
    name: String,
    onNameChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 65.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, bottom = 6.dp),
                text = stringResource(id = R.string.get_started_your_budget),
                color = Color.Black,
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontFamily = fonts,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            InputTextField(
                name = name,
                onNameChange = { name ->
                    onNameChange(name)
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewGetStartedTopInputComponent() {
    GetStartedTopInputComponent(
        name = "Daniel",
        onNameChange = {}
    )
}
