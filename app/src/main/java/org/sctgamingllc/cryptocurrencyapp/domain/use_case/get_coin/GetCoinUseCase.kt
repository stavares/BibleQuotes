package org.sctgamingllc.cryptocurrencyapp.domain.use_case.get_coin

import org.sctgamingllc.cryptocurrencyapp.common.Resource
import org.sctgamingllc.cryptocurrencyapp.data.remote.dto.toCoinDetail
import org.sctgamingllc.cryptocurrencyapp.domain.model.CoinDetail
import org.sctgamingllc.cryptocurrencyapp.domain.repository.CoinRepository
import jdk.jfr.internal.OldObjectSample.emit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage?:"An unexpected Http error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Could not reach the server. Check your internet connection."))
        }
    }
}