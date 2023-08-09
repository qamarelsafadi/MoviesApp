package com.qamar.data.utils

import com.qamar.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {

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