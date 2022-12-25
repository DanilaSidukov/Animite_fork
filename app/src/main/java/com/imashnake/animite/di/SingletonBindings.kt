package com.imashnake.animite.di

import com.imashnake.animite.data.sauce.network.apis.MediaApi
import com.imashnake.animite.data.sauce.network.apis.MediaListApi
import com.imashnake.animite.data.sauce.network.apis.SearchApi
import com.imashnake.animite.data.sauce.network.apis.apollo.ApolloMediaApi
import com.imashnake.animite.data.sauce.network.apis.apollo.ApolloMediaListApi
import com.imashnake.animite.data.sauce.network.apis.apollo.ApolloSearchApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SingletonBindings {

    @Singleton
    @Binds
    abstract fun providesMediaApi(
        apolloMediaApi: ApolloMediaApi
    ): MediaApi

    @Singleton
    @Binds
    abstract fun providesMediaListApi(
        apolloMediaListApi: ApolloMediaListApi
    ): MediaListApi

    @Singleton
    @Binds
    abstract fun providesSearchApi(
        apolloSearchApi: ApolloSearchApi
    ): SearchApi
}
