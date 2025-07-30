plugins {
    alias(libs.plugins.android.application)
}

android {
    signingConfigs {
        create("yanghy") {
            storeFile = file("../yanghy_key.jks")
            if (project.hasProperty("MYAPP_RELEASE_STORE_PASSWORD")) {
                storePassword = project.property("MYAPP_RELEASE_STORE_PASSWORD") as String
            }
            keyAlias = project.property("MYAPP_RELEASE_KEY_ALIAS") as String
            if (project.hasProperty("MYAPP_RELEASE_KEY_PASSWORD")) {
                keyPassword = project.property("MYAPP_RELEASE_KEY_PASSWORD") as String
            }
        }
    }
    namespace = "com.yanghy.fkdy"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.yanghy.fkdy"
        minSdk = 31
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.3"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        

    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("yanghy")
            if (project.hasProperty("MYAPP_RELEASE_STORE_PASSWORD")) {
                signingConfig = signingConfigs.getByName("yanghy")
            }
        }
        debug {
            isMinifyEnabled = false
            if (project.hasProperty("MYAPP_RELEASE_STORE_PASSWORD")) {
                signingConfig = signingConfigs.getByName("yanghy")
            }
        }
    }
    
    // 添加splits配置，用于分别打包64位和32位APK
    splits {
        abi {
            isEnable = false        // 分包
            isUniversalApk = false  // 成通用APK
            include("armeabi-v7a", "arm64-v8a")  // 只包含32位和64位ARM架构
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = false
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    compileOnly(files("libs/XposedAPI-89.jar"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}