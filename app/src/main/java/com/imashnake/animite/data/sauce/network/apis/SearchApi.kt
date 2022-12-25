package com.imashnake.animite.data.sauce.network.apis

import com.imashnake.animite.SearchQuery
import com.imashnake.animite.type.MediaType

interface SearchApi {
    suspend fun search(
        type: MediaType,
        perPage: Int,
        search: String
    ): SearchQuery.Page?
}
