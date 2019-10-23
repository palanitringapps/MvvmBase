package com.example.task.data.rest

import java.io.IOException
import java.io.InputStream
import java.util.zip.GZIPInputStream

import okhttp3.Interceptor

class DecodingInterceptor private constructor() : TransformingDecodingInterceptor() {

    @Throws(IOException::class)
    override fun transformInputStream(inputStream: InputStream): InputStream {
        return GZIPInputStream(inputStream)
    }

    companion object {
        internal val decodingInterceptor: Interceptor = DecodingInterceptor()
    }
}
