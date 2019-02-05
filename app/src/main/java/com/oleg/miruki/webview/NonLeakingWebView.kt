package com.oleg.miruki.webview

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.AttributeSet
import android.webkit.WebView
import android.webkit.WebViewClient
import java.lang.ref.WeakReference
import java.lang.reflect.Field

class NonLeakingWebView : WebView {

	constructor(context: Context) : super(context.applicationContext) {
		webViewClient = MyWebViewClient(
				context as Activity)
	}

	constructor(context: Context, attrs: AttributeSet) : super(context.applicationContext, attrs) {
		webViewClient = MyWebViewClient(
				context as Activity)
	}

	constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context.applicationContext, attrs,
	                                                                          defStyle) {
		webViewClient = MyWebViewClient(
				context as Activity)
	}

	override fun destroy() {
		super.destroy()
		try {
			if (sConfigCallback != null) sConfigCallback!!.set(null, null)
		} catch (e: Exception) {
			throw RuntimeException(e)
		}

	}

	protected class MyWebViewClient(activity: Activity) : WebViewClient() {
		protected var activityRef: WeakReference<Activity>

		init {
			this.activityRef = WeakReference(activity)
		}

		override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
			try {
				val activity = activityRef.get()
				activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
			} catch (ignored: RuntimeException) {
				// ignore any url parsing exceptions
			}

			return true
		}
	}

	companion object {
		private var sConfigCallback: Field? = null

		init {
			try {
				sConfigCallback = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback")
				sConfigCallback!!.isAccessible = true
			} catch (e: Exception) {
				// ignored
			}

		}
	}
}

