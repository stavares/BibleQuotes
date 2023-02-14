package org.sctgamingllc.cryptocurrencyapp.data.repository

import org.sctgamingllc.cryptocurrencyapp.data.remote.CoinPaprikaApi
import org.sctgamingllc.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import org.sctgamingllc.cryptocurrencyapp.data.remote.dto.CoinDto
import org.sctgamingllc.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}