package dev.sahildesai.bookhunt.di

import dev.sahildesai.bookhunt.book.data.database.DatabaseFactory
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single <HttpClientEngine>{ Darwin.create() }
        single { DatabaseFactory() }

    }