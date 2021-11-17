package com.example.materialdesign.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class Users(
    @PrimaryKey(autoGenerate = true) val userid : Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "number") val number: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "state") val state: String
)