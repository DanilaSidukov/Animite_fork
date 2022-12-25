package com.imashnake.animite.data.repos

import com.imashnake.animite.data.repos.mappers.MediaMapper
import com.imashnake.animite.data.sauce.db.medialist.MediaListDatabaseSource
import com.imashnake.animite.data.sauce.db.model.ListTag
import com.imashnake.animite.data.sauce.db.model.Media
import com.imashnake.animite.data.sauce.network.MediaListNetworkSource
import com.imashnake.animite.type.MediaSeason
import com.imashnake.animite.type.MediaSort
import com.imashnake.animite.type.MediaType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MediaListRepository @Inject constructor(
    private val mediaListNetworkSource: MediaListNetworkSource,
    private val mediaListDatabaseSource: MediaListDatabaseSource
) {

    fun getMediaList(
        tag: ListTag,
        mediaType: MediaType,
        sort: List<MediaSort>,
        page: Int = 0,
        perPage: Int = 10,
        season: MediaSeason? = null,
        seasonYear: Int? = null
    ): Flow<Result<List<Media>>> =
        mediaListDatabaseSource.getMedia(mediaType, tag)
            .onStart {
                mediaListDatabaseSource.insertMedia(
                    mediaListNetworkSource.fetchMediaList(
                        mediaType, page, perPage, sort, season, seasonYear
                    )?.media
                        .orEmpty()
                        .filterNotNull()
                        .map(MediaMapper::mediaApiToDB),
                    tag
                )
            }
            .map {
                Result.success(it)
            }
            .catch {
                emit(Result.failure(it))
            }
}
