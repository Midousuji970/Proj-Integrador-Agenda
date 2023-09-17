plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.portfolioandroid"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.portfolioandroid"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    viewBinding{
        enable = true
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
}

dependencies {



    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    implementation(platform("com.google.firebase:firebase-bom:32.2.2"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")


    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    val composeBom = platform("androidx.compose:compose-bom:2023.01.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    // Choose one of the following:
    implementation("androidx.compose.material3:material3")
        // or Material Design 2
    implementation("androidx.compose.material:material")
        // or skip Material Design and build directly on top of foundational components
    implementation("androidx.compose.foundation:foundation")
        // or only import the main APIs for the underlying toolkit systems,
        // such as input and measurement/layout

    implementation ("androidx.compose.ui:ui:1.5.1")

        // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

        // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

        // Optional - Included automatically by material, only add when you need
        // the icons but not the material library (e.g. when using Material3 or a
        // custom design system based on Foundation)
    implementation("androidx.compose.material:material-icons-core")
        // Optional - Add full set of material icons
    implementation("androidx.compose.material:material-icons-extended")
        // Optional - Add window size utils
    implementation("androidx.compose.material3:material3-window-size-class")

        // Optional - Integration with activities
    implementation("androidx.activity:activity-compose:1.6.1")
        // Optional - Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
        // Optional - Integration with LiveData
    implementation("androidx.compose.runtime:runtime-livedata")
        // Optional - Integration with RxJava
    implementation("androidx.compose.runtime:runtime-rxjava2")

    var nav_version = ("2.5.3")
    implementation ("androidx.navigation:navigation-compose:$nav_version")
}

