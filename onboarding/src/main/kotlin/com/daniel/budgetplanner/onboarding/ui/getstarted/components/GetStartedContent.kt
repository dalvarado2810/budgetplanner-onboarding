package com.daniel.budgetplanner.onboarding.ui.getstarted.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.base.ui.theme.fonts
import com.daniel.budgetplanner.onboarding.R
import com.daniel.budgetplanner.onboarding.ui.steps.utils.IMAGE_SALARY

@Composable
fun GetStartedContent(
    isPolicyCheck: Boolean,
    onPolicyChecked: (Boolean) -> Unit,
    clickableText: AnnotatedString
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.salary_day),
            contentDescription = IMAGE_SALARY,
            modifier = Modifier
                .fillMaxWidth()
                .height(235.dp)
                .padding(
                    top = 6.dp,
                    bottom = 6.dp
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 6.dp),
                text = stringResource(id = R.string.get_started_regulate_expenses),
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = fonts,
                    fontSize = 20.sp
                )
            )

            Text(
                text = stringResource(id = R.string.get_started_we_can_help),
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 22.dp,
                        end = 22.dp,
                        top = 6.dp,
                        bottom = 20.dp
                    )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Checkbox(
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = BudgetGreen,
                        checkedColor = Color.Black,
                        uncheckedColor = Color.Black,
                    ),
                    checked = isPolicyCheck,
                    onCheckedChange = {
                        onPolicyChecked(it)
                    }
                )

                Text(
                    text = clickableText
                )
            }
        }
    }
}

@Preview(name = "GetStartedContent")
@Composable
fun PreviewGetStartedContent() {
    GetStartedContent(
        isPolicyCheck = false,
        onPolicyChecked = {},
        clickableText = AnnotatedString("Haga click aqui")
    )
}
