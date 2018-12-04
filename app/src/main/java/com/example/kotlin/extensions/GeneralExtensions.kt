package com.example.extensions

import android.content.Context
import android.content.ContextWrapper
import android.content.SharedPreferences
import android.os.Build
import com.example.kotlin.BuildConfig

/**
 * Wrapping try/catch to ignore catch block
 */
inline fun <T> justTry(block: () -> T) = try {
    block()
} catch (e: Throwable) {
}

/**
 * App's debug mode
 */
inline fun debugMode(block: () -> Unit) {
    if (BuildConfig.DEBUG) {
        block()
    }
}

/**
 * For functionality supported above API 21 (Eg. Material design stuff)
 */
inline fun lollipopAndAbove(block: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        block()
    }
}

fun SharedPreferences.edit(a: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.a()
    editor.apply()
}

val ContextWrapper.sharedPreferences get() = getSharedPreferences("my_pref", Context.MODE_PRIVATE)
