package com.example.musictify.data.repositories.albums

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.musictify.data.remote.musicservice.SpotifyService
import com.example.musictify.data.repositories.tokenrepository.TokenRepository
import com.example.musictify.data.repositories.tokenrepository.withValidToken
import com.example.musictify.domain.ApiErrorType
import com.example.musictify.domain.SearchResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlbumRepositoryImp @Inject constructor(
    private val tokenRepo: TokenRepository,
    private val spotifyService: SpotifyService,
    private val pagingConfig: PagingConfig
): AlbumRepository {
    override suspend fun getAlbumById(
        albumId: String,
        country: String
    ): FetchedResource<SearchResult.Album, ApiErrorType> {
        tokenRepo.withValidToken {
            spotifyService.get
        }
    }

    override suspend fun getAlbumsByArtistId(
        artistId: String,
        country: String
    ): FetchedResource<List<SearchResult.Album>, ApiErrorType> {
        TODO("Not yet implemented")
    }

    override suspend fun getAlbumPagingStream(
        artistId: String,
        country: String
    ): Flow<PagingData<SearchResult.Album>> {
        TODO("Not yet implemented")
    }
}