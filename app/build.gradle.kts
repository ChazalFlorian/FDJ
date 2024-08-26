plugins {
    id("kotlin-android")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.fchazal.fdj"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fchazal.fdj"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.bundles.koin)
    implementation(libs.bundles.core)
    implementation(libs.bundles.ui)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.coroutine)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.misc)
    implementation(libs.material3.android)
    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.androidtest)
    debugImplementation(libs.bundles.debug)
}