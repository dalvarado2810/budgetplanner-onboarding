plugins {
    id("kotlin-android")
    id("com.android.library")
    id("maven-publish")
    id("io.gitlab.arturbosch.detekt")

    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.daniel.budgetplanner.onboarding"

    defaultConfig {
        minSdk = 26
        compileSdk = 35

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    publishing {
        singleVariant("debug") {
            withSourcesJar()
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

publishing {
    publications {
        create<MavenPublication>("debug") {
            groupId = "com.daniel.budgetplanner"
            artifactId = "onboarding"
            version = "1.0.0"

            afterEvaluate {
                from(components["debug"])
            }

            pom {
                name.set("Budget Onboarding")
            }
        }
    }
}

dependencies {
    /* Testing */
    testImplementation(libs.bundles.testing)

    /* Kotlin */
    implementation(libs.bundles.kotlin)

    /* AndroidX */
    implementation(libs.bundles.androidx)

    /* Compose */
    implementation(libs.bundles.compose)

    /* Navigation */
    implementation(libs.bundles.navigation)
    implementation(project(":navigation"))

    /* Koin */
    implementation(libs.bundles.koin)

    /* Base */
    implementation(libs.base)
}