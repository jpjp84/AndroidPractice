package com.jp.boilerplate.util

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder

object SharedPrefUtil {
    private fun getPreference(context: Context): SharedPreferences =
        context.getSharedPreferences("ANDROID_BOILERPLATE", Context.MODE_PRIVATE)

    private fun save(context: Context, key: String, value: String) {
        getPreference(context).edit().putString(key, value).apply()
    }

    fun <T> save(context: Context, key: String, value: T) {
        save(context, key, Gson().toJson(value).toString())
    }

    fun get(context: Context, key: String): String? {
        return getPreference(context).getString(key, "")
    }

    inline fun <reified T> get(context: Context, key: String): T? {
        return GsonBuilder().create().fromJson(get(context, key), T::class.java)
    }
}