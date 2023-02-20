package org.sctgamingllc.biblequotes.presentation.coin_detail

import org.sctgamingllc.biblequotes.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
