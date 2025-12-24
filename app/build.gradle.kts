plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.yanfaacourse"
    compileSdk = 35

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.example.yanfaacourse"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
//    buildFeatures {
//        viewBinding = true
//    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.play.services.maps)
    //firebase database
    implementation(libs.firebase.database)
    implementation(libs.firebase.auth)
    //implementation(libs.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.github.mhiew:android-pdf-viewer:3.2.0-beta.1") {
        exclude(group = "com.android.support", module = "support-compat")
        exclude(group = "com.android.support", module = "support-v4")

    }



    //implementation(libs.media3.exoplayer)
    implementation("androidx.media3:media3-exoplayer:1.8.0")
    implementation("androidx.media3:media3-ui:1.8.0")
    implementation("androidx.core:core:1.15.0")
    implementation("androidx.core:core-ktx:1.15.0")
    // Retrofit for networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
// Gson converter for JSON parsing
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")




}