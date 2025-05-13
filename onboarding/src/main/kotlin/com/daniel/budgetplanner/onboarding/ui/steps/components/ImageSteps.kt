package com.daniel.budgetplanner.onboarding.ui.steps.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.daniel.budgetplanner.onboarding.R
import com.daniel.budgetplanner.onboarding.ui.steps.utils.IMAGE_STEPS

@Composable
fun ImageSteps(
    image: Int,
    pt: Dp,
    pb: Dp,
    ps: Dp,
    width: Dp,
    height: Dp
    ) {
    Image(
        painter = painterResource(id = image),
        contentDescription = IMAGE_STEPS,
        modifier = Modifier
            .padding(top = pt, start = ps, bottom = pb)
            .width(width = width)
            .height(height = height)
    )
}

@Preview
@Composable
fun ImageStepsPreview() {
    ImageSteps(
        image = R.drawable.money_card,
        pt = 0.dp,
        pb = 0.dp,
        ps = 40.dp,
        width = 347.dp,
        height = 328.dp
    )
}
