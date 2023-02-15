package org.sctgamingllc.cryptocurrencyapp.data.remote.dto


//import org.sctgamingllc.cryptocurrencyapp.data.remote.dto.Stats
import com.google.gson.annotations.SerializedName
data class LinksExtended(
    val stats: Stats,
    val type: String,
    val url: String
)