package com.example.task.data.rest

import java.io.IOException
import java.io.InputStream

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Okio

abstract class TransformingDecodingInterceptor : Interceptor {
    @Throws(IOException::class)
    protected abstract fun transformInputStream(inputStream: InputStream): InputStream

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val body = response.body()
        return response.newBuilder()
            .body(
                ResponseBody.create(
                    body!!.contentType(),
                    body.contentLength(),
                    Okio.buffer(Okio.source(transformInputStream(body.byteStream())))
                )
            )
            .build()
    }
}
