package com.qamar.moviesapp.util

import android.content.Context
import com.qamar.data.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    @ApplicationContext private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        try {
            request = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .header("device_type", "android")
                .header("Authorization", BuildConfig.API_KEY)
                .build()

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return chain.proceed(request)

    }
}