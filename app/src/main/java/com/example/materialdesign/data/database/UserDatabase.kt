package com.example.materialdesign.data.database
import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.example.materialdesign.data.entity.Users

@Database(entities = [Users::class],  version = 1,exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: UserDatabase?= null

        fun getInstance(context: Context): UserDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user.db")
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}