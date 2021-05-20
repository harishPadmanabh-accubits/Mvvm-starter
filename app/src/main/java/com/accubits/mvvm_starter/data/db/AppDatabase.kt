package com.accubits.mvvm_starter.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.accubits.mvvm_starter.data.db.dao.UserDao
import com.accubits.mvvm_starter.data.models.UserModel


@Database(version = 1, entities = [UserModel::class])
abstract class AppDatabase :RoomDatabase() {

    abstract fun getUserDao():UserDao


    companion object{
        private const val mainDatabase="prod_database"
        @Volatile
        private var INSTANCE:AppDatabase?=null

        fun  getDatabase(context: Context):AppDatabase{
            val tempInstance= INSTANCE

            if(tempInstance!=null) return  tempInstance


            synchronized(this){
                val instance= Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java,mainDatabase)
                        .addCallback(object : Callback(){

                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                db.setTransactionSuccessful()
                                db.endTransaction()
                                db.beginTransaction()
                            }

                            override fun onOpen(db: SupportSQLiteDatabase) {
                                super.onOpen(db)
                            }
                        })
                        //ADD MIGRATIONS
                     //   .addMigrations(MIGRATION_1_2)
                        .build()

                INSTANCE=instance
                return  instance
            }
        }

    }


}