package dev.sahildesai.bookhunt.book.data.network

import dev.sahildesai.bookhunt.book.data.dto.BookWorkDto
import dev.sahildesai.bookhunt.book.data.dto.SearchResponseDto
import dev.sahildesai.bookhunt.book.domain.Book
import dev.sahildesai.bookhunt.utils.data.safeCall
import dev.sahildesai.bookhunt.utils.domain.DataError
import dev.sahildesai.bookhunt.utils.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

private const val BASE_URL = "https://openlibrary.org/"
private const val SEARCH = "search.json"

class KtorNetworkDataSource(
    private val httpClient: HttpClient
): IRemoteBookDataSource {
    override suspend fun searchBooks(
        query: String,
        resultLimit: Int?): Result<SearchResponseDto, DataError.Remote> =
        safeCall {
            httpClient.get (
                urlString = "$BASE_URL$SEARCH"
            ) {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter("fields", "key,title,author_name,author_key,cover_edition_key,cover_i,ratings_average,ratings_count,first_publish_year,language,number_of_pages_median,edition_count")

            }
        }

    override suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote> {
        return safeCall<BookWorkDto> {
            httpClient.get(
                urlString = "$BASE_URL/works/$bookWorkId.json"
            )
        }
    }
}