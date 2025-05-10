package dev.sahildesai.bookhunt

import androidx.compose.ui.window.ComposeUIViewController
import dev.sahildesai.bookhunt.app.App
import dev.sahildesai.bookhunt.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) {
    App()
}