import java.io.ByteArrayOutputStream

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
    publishing {
        singleVariant("release")
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.daniel.budgetplanner"
            artifactId = "onboarding"
            version = getVersionTag()

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set("Budget Onboarding")
            }
        }
    }
}

fun getVersionTag(): String {
    val stdout = ByteArrayOutputStream()
    try {
        exec {
            commandLine("git", "describe", "--tags", "--abbrev=0")
            standardOutput = stdout
        }
        val version = stdout.toString().trim()
        return if (version.startsWith("v")) version.substring(1) else version
    } catch (e: Exception) {
        return "1.0.0"
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
    implementation(libs.bundles.navigation.products)
}