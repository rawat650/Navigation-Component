package com.example.naviagationcomponent.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
    @Dao
    interface RegisterDao {
        @Insert
            (onConflict = OnConflictStrategy.REPLACE)
        suspend fun addData(data: RegisterEntity)
    }
