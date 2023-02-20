package org.sctgamingllc.biblequotes.domain.repository

import org.sctgamingllc.biblequotes.data.remote.dto.CoinDetailDto
import org.sctgamingllc.biblequotes.data.remote.dto.CoinDto


interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}