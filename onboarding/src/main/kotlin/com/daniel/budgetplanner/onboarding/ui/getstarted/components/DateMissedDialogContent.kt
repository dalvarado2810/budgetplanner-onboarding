package com.daniel.budgetplanner.onboarding.ui.getstarted.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.base.ui.theme.OnboardingBackground
import com.daniel.base.ui.theme.fonts
import com.daniel.budgetplanner.onboarding.R

@Composable
fun DateMissedDialogContent(
    onClickAction: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(OnboardingBackground)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.get_started_name_warning),
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontFamily = fonts,
                fontSize = 22.sp
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onClickAction,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 2.dp
            ),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = BudgetGreen,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(width = 145.dp)
                .height(height = 40.dp),
            contentPadding = PaddingValues(
                start = 32.dp,
                end = 32.dp
            ),
            enabled = true
        ) {
            Text(
                text = stringResource(id = R.string.get_started_close),
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 19.sp
                )
            )
        }
    }
}

@Preview
@Composable
fun Start(){
    DateMissedDialogContent {  }
}
