package org.sctgamingllc.biblequotes.data.repository

import org.sctgamingllc.biblequotes.data.remote.CoinPaprikaApi
import org.sctgamingllc.biblequotes.data.remote.dto.CoinDetailDto
import org.sctgamingllc.biblequotes.data.remote.dto.CoinDto
import org.sctgamingllc.biblequotes.domain.repository.CoinRepository
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