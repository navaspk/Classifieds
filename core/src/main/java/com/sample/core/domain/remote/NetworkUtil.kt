package com.sample.core.domain.remote

import com.sample.core.BuildConfig
import com.sample.core.extensions.safeGet
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.EOFException
import java.io.IOException
import java.net.HttpURLConnection.*
import java.util.concurrent.TimeUnit

class NetworkUtil constructor(
    gsonProvider: GsonProvider,
    endPoint: String
) {

    companion object {
        private const val HEADER_CONTENT_TYPE = "Content-Type"
        private const val HEADER_CONTENT_VALUE = "application/json"
        private const val CONNECT_TIME_OUT = 15L
        private const val READ_TIME_OUT = 15L

        private fun Response?.safeClose() {
            this?.let {
                try {
                    it.close()
                } catch (e: Exception) {

                }
            }
        }
    }

    private var retrofit: Retrofit

    /**
     * Retrofit initialization with base url, call adapter factory and conversion factory
     */
    init {
        retrofit = Retrofit.Builder()
            .baseUrl(endPoint)
            .client(getOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonProvider.instance))
            .build()
    }

    /**
     * Creating service class
     */
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    /**
     * Creating OKHTTP with interceptor for network call
     */
    private fun getOkHttpClient(): OkHttpClient {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()

        builder
            .addNetworkInterceptor(networkInterceptor())
            .addInterceptor(responseHandlerInterceptor())
            .addInterceptor(headerInterceptor())
            .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)

        return builder.build()
    }

    private fun networkInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        return loggingInterceptor
    }

    private fun headerInterceptor(): Interceptor {
        return Interceptor {
            val requestBuilder = it.request()
                .newBuilder()
                .addHeader(HEADER_CONTENT_TYPE, HEADER_CONTENT_VALUE)

            it.proceed(requestBuilder.build())
        }
    }

    private fun responseHandlerInterceptor(): Interceptor {
        return Interceptor {
            var response: Response? = null
            try {
                response = it.proceed(it.request()) as Response

                when (response.code()) {
                    HTTP_UNAVAILABLE -> {
                        throw ServerNotAvailableException("Server not available , please try again later")
                    }

                    HTTP_UNAUTHORIZED -> {
                        throw AuthorizationException(response.body()?.string().safeGet())
                    }

                    HTTP_FORBIDDEN -> {
                        throw Exception("Forbidder")
                    }

                    HTTP_NOT_FOUND -> {
                        throw HTTPNotFoundException("No data found")
                    }
                }
                response
            } catch (e: Exception) {
                response?.safeClose()
                e.printStackTrace()
                when (e) {
                    is HttpException,
                    is EOFException,
                    is HTTPNotFoundException,
                    is IOException -> {
                        throw e
                    }
                    else -> throw NetworkException(e)
                }
            }
        }
    }
}
