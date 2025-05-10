package dev.sahildesai.bookhunt.book.ui.book_detail

import dev.sahildesai.bookhunt.book.domain.Book


data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)