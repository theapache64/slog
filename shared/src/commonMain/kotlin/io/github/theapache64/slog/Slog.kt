package io.github.theapache64.slog

import de.jensklingenberg.ktorfit.Ktorfit
import io.github.theapache64.retrosheet.core.RetrosheetConfig
import io.github.theapache64.retrosheet.core.RetrosheetConverter
import io.github.theapache64.retrosheet.core.createRetrosheetPlugin
import io.ktor.client.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

internal const val SLOG_ENDPOINT = "add_log"

expect val IODispatcher: CoroutineDispatcher

object Slog {
    private lateinit var slogApi: SlogApi
    private val scope = CoroutineScope(IODispatcher)

    fun init(formUrl: String) {
        val config = RetrosheetConfig.Builder()
            .setLogging(true)
            // For writing to sheet
            .addForm(
                SLOG_ENDPOINT,
                formUrl // form link
            )
            .build()

        val ktorClient = HttpClient {
            install(createRetrosheetPlugin(config)) {}
        }

        slogApi = Ktorfit.Builder()
            .httpClient(ktorClient)
            .converterFactories(RetrosheetConverter(config))
            .build()
            .createSlogApi()
    }


    fun d(msg: () -> String) {
        scope.launch {
            slogApi.addLog(Log(msg()))
        }
    }
}