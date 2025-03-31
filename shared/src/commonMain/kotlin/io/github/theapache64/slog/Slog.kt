package io.github.theapache64.slog

import de.jensklingenberg.ktorfit.Ktorfit
import io.github.theapache64.retrosheet.core.RetrosheetConfig
import io.github.theapache64.retrosheet.core.RetrosheetConverter
import io.github.theapache64.retrosheet.core.createRetrosheetPlugin
import io.ktor.client.*

internal const val SLOG_ENDPOINT = "add_log"

object Slog {
    fun d(function: () -> String) {
        TODO("Not yet implemented")
    }

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

        return Ktorfit.Builder()
            .httpClient(ktorClient)
            .converterFactories(RetrosheetConverter(config))
            .build()
            .createSlogApi()
    }

}