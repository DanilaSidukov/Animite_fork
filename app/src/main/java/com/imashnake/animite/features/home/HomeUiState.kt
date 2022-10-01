package com.imashnake.animite.features.home

import com.imashnake.animite.MediaListQuery

data class HomeUiState(
    val trendingMediaList: MediaListQuery.Page? = null,
    val popularThisSeasonMediaList: MediaListQuery.Page? = null,
    val upcomingNextSeasonMediaList: MediaListQuery.Page? = null,
    val allTimePopularMediaList: MediaListQuery.Page? = null
)
