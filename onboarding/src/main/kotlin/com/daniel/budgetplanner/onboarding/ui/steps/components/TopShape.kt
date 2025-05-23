package com.daniel.budgetplanner.onboarding.ui.steps.components

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
import com.daniel.base.ui.theme.OnboardingBackground
import com.daniel.budgetplanner.onboarding.R
import com.daniel.budgetplanner.onboarding.domain.model.StepsData
import com.daniel.budgetplanner.onboarding.ui.steps.utils.IMAGE

@Composable
fun TopShape(
    modifier: Modifier,
    step: StepsData
) {
    val backGround = OnboardingBackground
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

        when (step) {
            StepsData.StepOne -> {
                ImageSteps(
                    image = step.image,
                    pt = 100.dp,
                    pb = 0.dp,
                    ps = 60.dp,
                    width = 260.dp,
                    height = 245.dp
                )
            }

            StepsData.StepTwo -> {
                ImageSteps(
                    image = step.image,
                    pt = 50.dp,
                    pb = 25.dp,
                    ps = 60.dp,
                    width = 260.dp,
                    height = 263.dp
                )
            }

            StepsData.StepThree -> {
                ImageSteps(
                    image = step.image,
                    pt = 30.dp,
                    pb = 0.dp,
                    ps = 40.dp,
                    width = 347.dp,
                    height = 328.dp
                )
            }
        }
    }
}

@Preview
@Composable
fun TopShapePreview() {
    TopShape(
        modifier = Modifier,
        step = StepsData.StepTwo
    )
}
