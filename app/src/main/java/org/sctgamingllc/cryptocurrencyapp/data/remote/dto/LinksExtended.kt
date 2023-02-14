package org.sctgamingllc.cryptocurrencyapp.data.remote.dto


import org.sctgamingllc.cryptocurrencyapp.data.remote.dto.Stats

data class LinksExtended(
    val stats: Stats,
    val type: String,
    val url: String
)