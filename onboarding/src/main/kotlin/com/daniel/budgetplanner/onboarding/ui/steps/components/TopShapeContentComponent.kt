package com.daniel.budgetplanner.onboarding.ui.steps.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun TopShapeContentComponent(
    modifier: Modifier = Modifier,
    title: Int,
    subTitle: Int
) {
    Box (
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = stringResource(id = title),
                color = Color.Black,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = fonts,
                    fontSize = 24.sp)
            )

            Text(
                text = stringResource(id = subTitle),
                color = Color.Black.copy(alpha = 0.7f),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontFamily = fonts,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                ), modifier = Modifier
                    .width(260.dp)
                    .padding(
                        top = 16.dp,
                        bottom = 20.dp
                    )
            )
        }
    }
}

@Preview(name = "TopShapeContentComponent")
@Composable
fun PreviewTopShapeContentComponent() {
    TopShapeContentComponent(
        title = R.string.onboarding_step_one_title,
        subTitle = R.string.onboarding_step_one_subtitle
    )
}
