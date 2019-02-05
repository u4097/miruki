import com.android.build.gradle.api.ApplicationVariant
import com.android.build.gradle.api.BaseVariantOutput
import com.android.build.gradle.internal.api.BaseVariantOutputImpl

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
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
    /*    implementation 'androidx.appcompat:appcompat:1.0.2'
		implementation 'androidx.core:core-ktx:1.0.1'
		implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
		testImplementation 'junit:junit:4.12'
		androidTestImplementation 'androidx.test.ext:junit:1.1.0'
		androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1'*/
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    implementation("androidx.appcompat:appcompat:${Versions.androidx}")
    implementation("androidx.core:core-ktx:${Versions.ktx}")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation ("androidx.cardview:cardview:1.0.0")

    // material design

    implementation ("com.google.android.material:material:1.1.0-alpha03")

    // material dialog
    implementation("com.afollestad.material-dialogs:core:2.0.0-rc10")

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
}
