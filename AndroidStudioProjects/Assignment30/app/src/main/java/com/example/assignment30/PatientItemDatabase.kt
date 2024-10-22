package com.example.assignment30

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PatientItem::class], version = 1, exportSchema = false)
abstract class PatientItemDatabase: RoomDatabase() {

    abstract fun patientItemDao(): PatientItemDao

    companion object
    {
        @Volatile
        private var INSTANCE: PatientItemDatabase? = null

        fun getDatabase(context: Context): PatientItemDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                PatientItemDatabase::class.java,
                "patient_item_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}