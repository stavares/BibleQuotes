package org.sctgamingllc.cryptocurrencyapp.presentation.coin_list

import org.sctgamingllc.cryptocurrencyapp.domain.model.Coin
//import java.util.Collections.emptyList

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
