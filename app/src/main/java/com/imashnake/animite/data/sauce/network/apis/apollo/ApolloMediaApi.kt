package com.imashnake.animite.data.sauce.network.apis.apollo

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.imashnake.animite.MediaQuery
import com.imashnake.animite.MediaQuery.Media
import com.imashnake.animite.data.sauce.network.apis.MediaApi
import com.imashnake.animite.type.MediaType
import javax.inject.Inject

/**
 * Example:
 *
 * **Anime:** Sono Bisque Doll wa Koi wo Suru;
 * **ID:** 132405.
 */
class ApolloMediaApi @Inject constructor(
    private val apolloClient: ApolloClient
) : MediaApi {
    override suspend fun fetchMedia(id: Int?, mediaType: MediaType): Media? {
        return apolloClient
            .query(
                MediaQuery(
                    id = Optional.presentIfNotNull(id),
                    type = Optional.presentIfNotNull(mediaType)
                )
            ).execute().data?.media
    }
}
