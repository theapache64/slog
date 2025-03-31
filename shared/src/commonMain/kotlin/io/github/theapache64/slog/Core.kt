package io.github.theapache64.slog

import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.POST
import io.github.theapache64.retrosheet.annotations.Write
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Log(
    @SerialName("message")
    val msg : String
)

internal interface SlogApi {
    @Write
    @POST(SLOG_ENDPOINT)
    suspend fun addLog(@Body log: Log): Log
}