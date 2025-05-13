package com.daniel.budgetplanner.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.daniel.base.Product
import com.daniel.budgetplanner.onboarding.di.onboardingModule
import com.daniel.budgetplanner.onboarding.navigation.OnboardingDestination
import com.daniel.budgetplanner.onboarding.presentation.steps.route.OnboardingRoute
import org.koin.core.module.Module

object OnboardingProduct : Product() {
    override fun onInitNavigation(navController: NavController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation<OnboardingDestination.NavGraph>(
            startDestination = OnboardingDestination.Onboarding) {
               composable<OnboardingDestination.Onboarding> {
                   OnboardingRoute(
                       onNavigateToGetStarted = {}
                   )
               }
        }
    }

    override fun getModules(): List<Module> {
        return listOf(
            onboardingModule
        )
    }
}