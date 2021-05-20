package com.accubits.mvvm_starter.data.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// add db migrations

//val MIGRATION_1_2 = object : Migration(1, 2) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("CREATE TABLE notifications (`id` INTEGER NOT NULL, `action` TEXT, `object_type` TEXT, `object_data` TEXT, `timestamp` TEXT, `channel` TEXT, `event_code` TEXT, `user_visible` INTEGER NOT NULL, `created_at` TEXT, `updated_at` TEXT, `expires_at` TEXT, PRIMARY KEY(`id`))")
//    }
//}