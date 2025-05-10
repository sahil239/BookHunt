package dev.sahildesai.bookhunt.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import dev.sahildesai.bookhunt.book.data.database.DatabaseFactory
import dev.sahildesai.bookhunt.book.data.database.FavoriteBookDatabase
import dev.sahildesai.bookhunt.book.data.network.IRemoteBookDataSource
import dev.sahildesai.bookhunt.book.data.network.RemoteBookDataSource
import dev.sahildesai.bookhunt.book.data.repository.BookRepository
import dev.sahildesai.bookhunt.book.domain.IBookRepository
import dev.sahildesai.bookhunt.utils.data.HttpClientFactory
import dev.sahildesai.bookhunt.book.ui.book_list.BookListViewModel
import dev.sahildesai.bookhunt.book.ui.book_detail.BookDetailViewModel
import dev.sahildesai.bookhunt.book.ui.SelectedBookViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }

    singleOf(::RemoteBookDataSource).bind<IRemoteBookDataSource>()
    singleOf(::BookRepository).bind<IBookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}