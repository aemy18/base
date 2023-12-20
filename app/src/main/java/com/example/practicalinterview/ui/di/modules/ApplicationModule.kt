package com.example.practicalinterview.ui.di.modules


import com.example.practicalinterview.ui.di.core.AppSession
import com.example.practicalinterview.ui.di.core.Session
import com.example.practicalinterview.ui.di.repository.ApiService
import com.example.practicalinterview.ui.di.repository.UserRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun providesFakerAPI(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepository(apiService)
    }

    @Provides
    @Singleton
    internal fun getSession(session: AppSession): Session = session

    @Provides
    @Singleton
    internal fun getGson(): Gson = Gson()
}