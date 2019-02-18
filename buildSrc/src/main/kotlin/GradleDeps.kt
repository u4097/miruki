object AppVersion {
	// App version information
	const val majorAppVersion = 1
	const val minorAppVersion = 1
	const val patchAppVersion = 1
	const val buildAppVersion = 0
}

object ApplicationId {
	const val id = "com.oleg.miruki"
}

object Android {
	const val compileSdkVersion = 28
	const val minSdkVersion = 21
	const val targetSdkVersion = 28
}


object Modules {
	const val app = ":app"
}

object Versions {
	const val gradle = "3.5.0-alpha04"
	const val kotlin = "1.3.21"
	const val androidx = "1.1.0-alpha02"
	const val ktx = "1.1.0-alpha04"

	const val constraintLayout = "2.0.0-alpha3"
	const val  testEspresso = "3.1.2-alpha01"
	const val junit = "4.13-beta-2"
    const val junitExt = "1.1.1-alpha01"

	const val fabric = "1.27.1"
	const val crashlytics = "2.9.9"
}


object Libraries {
	const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
	const val androidx = "androidx.appcompat:appcompat:${Versions.androidx}"
	const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
	const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

}


object AppConstants {
}
