package com.imashnake.animite.data.sauce.apis

import com.apollographql.apollo3.api.ApolloResponse
import com.imashnake.animite.SearchQuery
import com.imashnake.animite.type.MediaType
import kotlinx.coroutines.flow.Flow

interface SearchApi {
    fun search(
        type: MediaType,
        perPage: Int,
        search: String?
    ): Flow<ApolloResponse<SearchQuery.Data>>
}