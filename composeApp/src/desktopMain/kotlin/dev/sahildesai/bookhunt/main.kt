package dev.sahildesai.bookhunt

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.sahildesai.bookhunt.app.App
import dev.sahildesai.bookhunt.di.initKoin

fun main() {

    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Book Hunt",
        ) {
            App()
        }
    }
}