package com.imashnake.animite.data.sauce.db.medialist

import com.imashnake.animite.data.sauce.db.dao.MediaDao
import com.imashnake.animite.data.sauce.db.dao.MediaLinkDao
import com.imashnake.animite.data.sauce.db.model.ListTag
import com.imashnake.animite.data.sauce.db.model.Media
import com.imashnake.animite.data.sauce.db.model.MediaLink
import com.imashnake.animite.type.MediaType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MediaListDatabaseSource @Inject constructor(
    private val mediaDAO: MediaDao,
    private val mediaLinkDao: MediaLinkDao
) {

    suspend fun insertMedia(media: List<Media>, tag: ListTag) {
        mediaLinkDao.insertAll(*media.map { MediaLink(it.id, tag) }.toTypedArray())
        mediaDAO.insertAll(*media.toTypedArray())
    }

    fun getMedia(mediaType: MediaType, tag: ListTag): Flow<List<Media>> {
        return mediaDAO.getAll(mediaType, tag)
    }
}