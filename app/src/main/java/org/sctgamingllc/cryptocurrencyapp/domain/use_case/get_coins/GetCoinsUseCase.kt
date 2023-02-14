package org.sctgamingllc.cryptocurrencyapp.domain.use_case.get_coins

import org.sctgamingllc.cryptocurrencyapp.common.Resource
import org.sctgamingllc.cryptocurrencyapp.data.remote.dto.toCoin
import org.sctgamingllc.cryptocurrencyapp.domain.model.Coin
import org.sctgamingllc.cryptocurrencyapp.domain.repository.CoinRepository
import jdk.jfr.internal.OldObjectSample.emit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage?:"An unexpected Http error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Could not reach the server. Check your internet connection."))
        }
    }
}