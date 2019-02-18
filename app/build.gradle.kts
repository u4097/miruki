import com.android.build.gradle.api.ApplicationVariant
import com.android.build.gradle.api.BaseVariantOutput
import com.android.build.gradle.internal.api.BaseVariantOutputImpl

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("com.github.ben-manes.versions") version "0.20.0" // uses gradle depUp ; show old dependencies in termina
    id("io.fabric")
}



android {
    compileSdkVersion(Android.compileSdkVersion)
    defaultConfig {
        applicationId = ApplicationId.id
        minSdkVersion(Android.minSdkVersion)
        targetSdkVersion(Android.targetSdkVersion)


        versionCode = (AppVersion.majorAppVersion * 10_000) + (AppVersion.minorAppVersion * 1_000) + (AppVersion.patchAppVersion * 100)

        versionName  = "${AppVersion.majorAppVersion}" +
                       ".${AppVersion.minorAppVersion}" +
                       ".${AppVersion.patchAppVersion}"


        applicationVariants.all(object : Action<ApplicationVariant> {
            override fun execute(variant: ApplicationVariant) {
                println("variant: $variant")
                variant.outputs.all(object : Action<BaseVariantOutput> {
                    override fun execute(output: BaseVariantOutput) {

                        val outputImpl = output as BaseVariantOutputImpl
                        val fileName = output.outputFileName
                            .replace("-release", "-release-v$versionName-vc$versionCode")
                            .replace("-debug", "-debug-v$versionName-vc$versionCode")
                        println("output file name: $fileName")
                        outputImpl.outputFileName = fileName
                    }
                })
            }
        })



        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    implementation("androidx.appcompat:appcompat:${Versions.androidx}")
    implementation("androidx.core:core-ktx:${Versions.ktx}")
    implementation("androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}")
    implementation("com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}")

    testImplementation("junit:junit:${Versions.junit}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.junitExt}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.testEspresso}")


}
