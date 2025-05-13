package com.daniel.budgetplanner.onboarding.ui.steps.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniel.base.ui.theme.BudgetGreen
import com.daniel.budgetplanner.onboarding.R
import com.daniel.budgetplanner.onboarding.ui.steps.utils.IMAGE_ONBOARDING_STEP

@Composable
fun OnboardingNextStepButton(
    color: Color = BudgetGreen,
    onButtonClick: () -> Unit
) {
    Button(
        onClick = onButtonClick,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .width(width = 77.dp)
            .height(height = 78.dp)
            .padding(top= 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.continue_onboarding_step),
            contentDescription = IMAGE_ONBOARDING_STEP,
            alignment = Alignment.Center,
            modifier = Modifier
                .width(width = 174.dp)
                .height(height = 52.dp)
        )
    }
}

@Preview
@Composable
fun Show(){
     OnboardingNextStepButton { }
}
