package dev.sahildesai.bookhunt.book.data.network

import dev.sahildesai.bookhunt.book.data.dto.BookWorkDto
import dev.sahildesai.bookhunt.book.data.dto.SearchResponseDto
import dev.sahildesai.bookhunt.utils.domain.DataError
import dev.sahildesai.bookhunt.utils.domain.Result

interface IRemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

   suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}