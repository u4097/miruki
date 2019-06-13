// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.gradle.build-scan") version "2.1"
}

buildscript {
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.0-alpha03")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.20")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}

buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
    publishAlways()
}


tasks.register("clean",Delete::class.java) {
    delete(rootProject.buildDir)
}
