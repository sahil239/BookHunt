package dev.sahildesai.bookhunt.book.data.repository

import androidx.sqlite.SQLiteException
import dev.sahildesai.bookhunt.book.data.database.FavoriteBookDao
import dev.sahildesai.bookhunt.book.data.network.IRemoteBookDataSource
import dev.sahildesai.bookhunt.book.data.mappers.toBook
import dev.sahildesai.bookhunt.book.data.mappers.toBookEntity
import dev.sahildesai.bookhunt.book.domain.Book
import dev.sahildesai.bookhunt.book.domain.IBookRepository
import dev.sahildesai.bookhunt.utils.domain.DataError
import dev.sahildesai.bookhunt.utils.domain.EmptyResult
import dev.sahildesai.bookhunt.utils.domain.Result
import dev.sahildesai.bookhunt.utils.domain.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BookRepository(
    private val remoteBookDataSource: IRemoteBookDataSource,
    private val favoriteBookDao: FavoriteBookDao
): IBookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        val localResult = favoriteBookDao.getFavoriteBook(bookId)

        return if(localResult == null) {
            remoteBookDataSource
                .getBookDetails(bookId)
                .map { it.description }
        } else {
            Result.Success(localResult.description)
         }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao.getFavoriteBooks().map { bookEntities -> bookEntities.map { it.toBook() } }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favoriteBookDao.getFavoriteBooks().map { bookEntities -> bookEntities.any { it.id == id} }
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favoriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException){
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorites(id: String) {
        favoriteBookDao.deleteFavoriteBook(id)
    }
}