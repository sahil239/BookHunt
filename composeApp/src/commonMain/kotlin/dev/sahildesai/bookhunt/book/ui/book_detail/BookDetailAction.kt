package dev.sahildesai.bookhunt.book.ui.book_detail

import dev.sahildesai.bookhunt.book.domain.Book


sealed interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnFavoriteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction
}