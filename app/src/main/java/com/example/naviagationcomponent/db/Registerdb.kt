package com.example.naviagationcomponent.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [(RegisterEntity::class)],version = 1)
    abstract class RegisterDb : RoomDatabase(){

        abstract fun registerDao(): RegisterDao

        companion object{
            @Volatile
            private var instance:RegisterDb? = null
            private val LOCK =Any()

            operator fun invoke(context: Context) = instance?: synchronized(LOCK){
                instance?:createDatabase(context).also{ instance = it}
            }

            private fun createDatabase(context: Context)=
                Room.databaseBuilder(
                    context.applicationContext,RegisterDb::class.java,
                    "register_db.db"
                ).build()
        }
    }

