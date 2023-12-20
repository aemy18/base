package com.example.practicalinterview.ui.di.modules

import com.example.practicalinterview.ui.di.core.Session
import com.example.practicalinterview.ui.di.repository.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule {
    @Singleton
    @Provides
    internal fun provideClient(
        @Named("header") headerInterceptor: Interceptor,
        @Named("pre_validation") networkInterceptor: Interceptor
    ): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(networkInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    @Named("header")
    internal fun provideHeaderInterceptor(session: Session): Interceptor {
        return Interceptor { chain ->
            val build = chain.request().newBuilder()
                .build()
            chain.proceed(build)
        }
    }

    @Singleton
    @Provides
    @Named("pre_validation")
    internal fun provideNetworkInterceptor(): Interceptor {
        return Interceptor { chain ->
            val response = chain.proceed(chain.request())
            val code = response.code
            if (code >= 500)
                throw IOException("Unknown Server Error")
            else if (code == 401 || code == 403)
                throw IOException("Authentication Error")
            else response
        }
    }


}