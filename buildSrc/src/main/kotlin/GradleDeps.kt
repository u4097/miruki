object Release {
	const val versionName = "v0.0"
	const val versionCode = 0
}

object ApplicationId {
	const val id = "com.oleg.miruki"
}

object Android {
	const val compileSdkVersion = 28
	const val minSdkVersion = 21
	const val targetSdkVersion = 28
}

object AppVersion {
	// App version information
	const val majorAppVersion = 1
	const val minorAppVersion = 1
	const val patchAppVersion = 0
	const val buildAppVersion = 0
}


object Modules {
	const val app = ":app"
//	const val preference = ":preference"
}

object Versions {
	const val gradle = "3.6.0-alpha03"
	const val googleServicies = "4.2.0"
	const val kotlin = "1.3.20"
	const val androidx = "1.0.2"
	const val lifecycle = "2.0.0"
	const val ktx = "1.0.0-alpha1"


	const val retrofit = "2.5.0"

	const val fresco = "1.11.0"
	const val lottie = "2.5.4"
	const val decoro = "1.1.1"
	const val showhidepasswordedittext = "0.8"

	const val chuck = "1.1.0"
	const val timber = "4.7.1"
	const val fabric = "1.27.0"
	const val firebase = "16.0.4"
	const val firebaseMessaging = "17.3.4"
}


object Libraries {
	const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
	const val androidx = "androidx.appcompat:appcompat:${Versions.androidx}"
	const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
	const val lifecycle = "android.arch.lifecycle:extensions:${Versions.lifecycle}"

	const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-alpha3"
	const val fresco = "com.facebook.fresco:fresco:1.11.0"

	const val lottie = "com.airbnb.android:lottie:2.5.4"
	const val decoro = "ru.tinkoff.decoro:decoro:1.1.1"
	const val showhidepasswordedittext = "com.github.scottyab:showhidepasswordedittext:0.8"

	const val retrofit = "com.squareup.retrofit2:retrofit:2.5.0"
	const val retrofitCoroutines = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
	const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.0"
	const val moshi = "com.squareup.retrofit2:converter-moshi:2.5.0"

	const val okhttp = "com.squareup.okhttp3:okhttp:3.12.0"
	const val okhttpLoging = "com.squareup.okhttp3:logging-interceptor:3.12.0"

	const val anko = "org.jetbrains.anko:anko:0.10.8"

	const val timber = "com.jakewharton.timber:timber:4.7.1"
	const val fireBase = "com.google.firebase:firebase-core:16.0.6"
	const val fireBaseMessaging = "com.google.firebase:firebase-messaging:17.3.4"

	const val chuck = "com.readystatesoftware.chuck:library:1.1.0"
	const val chuckRelease = "com.readystatesoftware.chuck:library-no-op:1.1.0"
}


object AppConstants {
	const val DEBUGURL = "\"http://46.254.21.94:9000/api/v1/\""
	const val BASEURL = "\"http://api.winstrike.ru:8000/api/v1/\""
}
