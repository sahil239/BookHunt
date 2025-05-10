package dev.sahildesai.bookhunt.book.ui.book_list

import dev.sahildesai.bookhunt.book.domain.Book
import dev.sahildesai.bookhunt.utils.ui.UiText

data class BookListState(
    val searchQuery: String = "book",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)