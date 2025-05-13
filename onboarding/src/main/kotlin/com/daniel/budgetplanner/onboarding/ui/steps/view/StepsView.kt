package com.daniel.budgetplanner.onboarding.ui.steps.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniel.base.ui.theme.OnboardingBackground
import com.daniel.budgetplanner.onboarding.domain.model.StepsData
import com.daniel.budgetplanner.onboarding.presentation.steps.mvi.Onboarding
import com.daniel.budgetplanner.onboarding.ui.steps.components.OnboardingNextStepButton
import com.daniel.budgetplanner.onboarding.ui.steps.components.TopShape
import com.daniel.budgetplanner.onboarding.ui.steps.components.TopShapeContentComponent
import com.daniel.budgetplanner.onboarding.ui.steps.utils.IMAGE_STEP_IMAGE

@Composable
fun StepsView(
    state: Onboarding.State.OnboardingStep,
    onNextButtonClick: (StepsData) -> Unit
) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .fillMaxSize()
            .background(color = OnboardingBackground)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            TopShape(
                modifier = Modifier.weight(1f),
                step = state.stepsData
            )

            TopShapeContentComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                title = state.stepsData.title,
                subTitle = state.stepsData.subTitle
            )

            Box {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = state.stepsData.stepImage),
                        contentDescription = IMAGE_STEP_IMAGE,
                        modifier = Modifier
                            .padding(top = 36.dp)
                            .width(width = 74.dp)
                            .height(height = 24.dp)
                    )

                    OnboardingNextStepButton {
                        onNextButtonClick(state.stepsData)
                    }
                }
            }
        }
    }
}

@Preview(name = "StepsView")
@Composable
fun PreviewStepsView() {
    StepsView(
        state = Onboarding.State.OnboardingStep(
            stepsData = StepsData.StepThree
        ),
        onNextButtonClick = { }
    )
}
