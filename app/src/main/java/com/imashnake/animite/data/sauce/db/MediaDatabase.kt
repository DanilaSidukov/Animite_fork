package com.imashnake.animite.data.sauce.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.imashnake.animite.data.sauce.db.dao.MediaDao
import com.imashnake.animite.data.sauce.db.dao.MediaLinkDao
import com.imashnake.animite.data.sauce.db.model.Media
import com.imashnake.animite.data.sauce.db.model.MediaLink

@Database(
    version = 2,
    entities = [
        Media::class,
        MediaLink::class
    ]
)
abstract class MediaDatabase : RoomDatabase() {
    abstract fun mediaDao(): MediaDao
    abstract fun mediaLinkDao(): MediaLinkDao
}