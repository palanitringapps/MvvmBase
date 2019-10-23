package com.example.task.data.rest

import com.google.common.io.BaseEncoding
import java.io.InputStream
import java.io.InputStreamReader

import okhttp3.Interceptor

class Base64DecodingInterceptor private constructor() : TransformingDecodingInterceptor() {

    override fun transformInputStream(inputStream: InputStream): InputStream {
        return BaseEncoding.base64().decodingStream(InputStreamReader(inputStream))
    }

    companion object {

        internal val base64DecodingInterceptor: Interceptor = Base64DecodingInterceptor()
    }
}
