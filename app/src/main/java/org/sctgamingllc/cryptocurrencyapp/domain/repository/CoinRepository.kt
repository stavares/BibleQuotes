package org.sctgamingllc.cryptocurrencyapp.domain.repository

import org.sctgamingllc.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import org.sctgamingllc.cryptocurrencyapp.data.remote.dto.CoinDto


interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}