package com.daniel.budgetplanner.onboarding.ui.getstarted.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniel.base.ui.theme.BudgetGreen

@Composable
fun ContinueButton(
    text: String,
    enabled: Boolean = true,
    onButtonClick: () -> Unit
) {
    Button(
        onClick = onButtonClick,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp
        ),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = BudgetGreen,
            disabledContainerColor = Color.LightGray,
        ),
        modifier = Modifier
            .width(width = 325.dp)
            .height(height = 60.dp),
        contentPadding = PaddingValues(
            top = 6.dp,
            start = 32.dp,
            end = 32.dp
        ),
        enabled = enabled
    ) {
        Text(
            text = text,
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 19.sp
            )
        )
    }
}

@Preview
@Composable
fun ContinueButtonPreview(){
    ContinueButton(
        text = "Continuar",
        onButtonClick = {}
    )
}
