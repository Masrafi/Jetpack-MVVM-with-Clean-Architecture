package com.loc.newsapp.core.di

import android.app.Application
import com.loc.newsapp.feature.home.data.data_source.HomeApiService
import com.loc.newsapp.feature.home.data.repository.HomeRepositoryImpl
import com.loc.newsapp.feature.home.domain.repository.HomeRepository
import com.loc.newsapp.feature.home.domain.usecases.HomeUseCases
import com.loc.newsapp.feature.onBoarding.domain.manager.LocalUserManger
import com.loc.newsapp.feature.onBoarding.data.manager.LocalUserMangerImpl
import com.loc.newsapp.feature.onBoarding.domain.usecase.AppEntryUseCases
import com.loc.newsapp.feature.onBoarding.domain.usecase.ReadAppEntry
import com.loc.newsapp.feature.onBoarding.domain.usecase.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.converter.gson.GsonConverterFactory
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.loc.newsapp.core.util.Constants.BASE_URL
import com.loc.newsapp.feature.demo.data.data_source.DemoApiService
import com.loc.newsapp.feature.demo.data.repository.DemoRepositoryImpl
import com.loc.newsapp.feature.demo.domain.repository.DemoRepository
import com.loc.newsapp.feature.demo.domain.usecases.DemoUseCases
import com.loc.newsapp.feature.demo.domain.usecases.SendDemoDataUseCase
import com.loc.newsapp.feature.home.domain.usecases.NewsUseCases
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
    @Provides
    @Singleton
    fun provideApiInstance(): HomeApiService {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HomeApiService::class.java)
    }
    @Provides
    @Singleton
    fun provideHomeRepository(
        newsApi: HomeApiService 
    ): HomeRepository {
        return HomeRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideHomeUseCases(
        newsRepository: HomeRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = HomeUseCases(newsRepository),
            //searchNews = SearchNews(newsRepository)
        )
    }


    @Provides
    @Singleton
    fun provideDemoApi(): DemoApiService {
        return Retrofit.Builder()
            .baseUrl("https://atb-jobs.com:8000/api/v1/app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DemoApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDemoRepository(
        demoApi: DemoApiService
    ): DemoRepository = DemoRepositoryImpl(demoApi)

    @Provides
    @Singleton
    fun provideDemoUseCases(
        demoRepository: DemoRepository
    ): DemoUseCases = DemoUseCases(
        sendDemoData = SendDemoDataUseCase(demoRepository)
    )


}