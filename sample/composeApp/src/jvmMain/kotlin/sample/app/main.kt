import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import io.github.theapache64.slog.Slog
import sample.app.App

fun main() = application {

    Slog.init("https://docs.google.com/forms/d/e/1FAIpQLSdzQmv-q-IjY9w_VCkkuyo716junf7ukNeQu3KQ1YGKfHPSfA/viewform?usp=dialog")

    Window(
        title = "sample",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        App()
    }
}