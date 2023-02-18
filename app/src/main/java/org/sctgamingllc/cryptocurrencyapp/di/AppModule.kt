package org.sctgamingllc.cryptocurrencyapp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import org.sctgamingllc.cryptocurrencyapp.common.Constants
import org.sctgamingllc.cryptocurrencyapp.data.remote.CoinPaprikaApi
import org.sctgamingllc.cryptocurrencyapp.domain.repository.CoinRepository
import org.sctgamingllc.cryptocurrencyapp.data.repository.CoinRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}