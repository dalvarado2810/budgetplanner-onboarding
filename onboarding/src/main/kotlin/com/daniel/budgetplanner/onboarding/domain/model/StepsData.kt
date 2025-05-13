package com.daniel.budgetplanner.onboarding.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.daniel.budgetplanner.onboarding.R

sealed class StepsData(
    @DrawableRes val image: Int,
    @DrawableRes val stepImage: Int,
    @StringRes val title: Int,
    @StringRes val subTitle: Int
) {
    object StepOne : StepsData(
        image = R.drawable.money_card,
        stepImage = R.drawable.step_1,
        title = R.string.onboarding_step_one_title,
        subTitle = R.string.onboarding_step_one_subtitle
    )

    object StepTwo : StepsData(
        image = R.drawable.categories_top_image,
        stepImage = R.drawable.step_2,
        title = R.string.onboarding_step_two_title,
        subTitle = R.string.onboarding_step_two_subtitle
    )

    object StepThree : StepsData(
        image = R.drawable.secure_info,
        stepImage = R.drawable.step_3,
        title = R.string.onboarding_step_three_title,
        subTitle = R.string.onboarding_step_three_subtitle
    )
}
