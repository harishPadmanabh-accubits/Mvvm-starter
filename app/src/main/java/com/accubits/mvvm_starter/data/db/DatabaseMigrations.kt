package com.accubits.mvvm_starter.data.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// add db migrations

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
      //  database.execSQL("CREATE TABLE food_tb (`id` TEXT NOT NULL PRIMARY KEY , `name` TEXT, `desc` TEXT)")
        database.execSQL("CREATE TABLE food_tb (`id` TEXT PRIMARY KEY  NOT NULL, `name` TEXT NOT NULL, `desc` TEXT NOT NULL)")

    }
}