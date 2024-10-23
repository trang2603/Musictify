package com.example.musictify.data.repositories.albums

import androidx.paging.PagingData
import com.example.musictify.domain.ApiErrorType
import com.example.musictify.domain.SearchResult
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {
    suspend fun getAlbumById(
        albumId: String,
        country: String
    ): FetchedResource<SearchResult.Album, ApiErrorType>

    suspend fun getAlbumsByArtistId(
        artistId: String,
        country: String
    ): FetchedResource<List<SearchResult.Album>, ApiErrorType>

    suspend fun getAlbumPagingStream(
        artistId: String,
        country: String
    ): Flow<PagingData<SearchResult.Album>>
}