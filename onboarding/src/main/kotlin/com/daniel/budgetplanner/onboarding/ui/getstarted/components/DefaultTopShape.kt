package com.daniel.budgetplanner.onboarding.ui.getstarted.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniel.base.ui.theme.BackGround
import com.daniel.budgetplanner.onboarding.R
import com.daniel.budgetplanner.onboarding.ui.steps.utils.IMAGE

@Composable
fun DefaultTopShape(
    modifier: Modifier = Modifier
) {
    val backGround = BackGround
    val moneyTopImg = R.drawable.money_top

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(backGround)
    ) {
        Image(
            painter = painterResource(id = moneyTopImg),
            contentDescription = IMAGE,
            modifier = Modifier
                .width(width = 218.dp)
                .height(height = 172.dp),
        )
    }
}

@Preview
@Composable
fun DefaultTopShapePreview() {
    DefaultTopShape(
        modifier = Modifier
    )
}
