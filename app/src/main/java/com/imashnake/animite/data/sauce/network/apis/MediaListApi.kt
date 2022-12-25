package com.imashnake.animite.data.sauce.network.apis

import com.imashnake.animite.MediaListQuery
import com.imashnake.animite.type.MediaSeason
import com.imashnake.animite.type.MediaSort
import com.imashnake.animite.type.MediaType

interface MediaListApi {
    suspend fun fetchMediaList(
        type: MediaType,
        page: Int,
        perPage: Int,
        sort: List<MediaSort>,
        season: MediaSeason?,
        seasonYear: Int?
    ): MediaListQuery.Page?

    // And potentially other functions that help sort/modify the list.
}
