plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.todolist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.todolist"
        minSdk = 25
        targetSdk = 34
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
    buildFeatures{
        dataBinding=true
        viewBinding=true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    //    fast adapter
    implementation(libs.fastadapter)
//    fast adapter view binding
    implementation(libs.fastadapter.extensions.ui)
//    Diff util extension for better performance of the recyclerview
    implementation(libs.fastadapter.extensions.diff)
//    fast adapter binding Extension(for data binding support)
    implementation(libs.fastadapter.extensions.binding)
//    room library
    implementation(libs.room.runtime)
//    annotation processor for room
    annotationProcessor(libs.room.compiler)
//    viewmodel
    implementation(libs.lifecycle.viewmodel)
//    Livedata and mutable live data
    implementation(libs.lifecycle.livedata)
// data binding
    implementation(libs.databinding.runtime)



}