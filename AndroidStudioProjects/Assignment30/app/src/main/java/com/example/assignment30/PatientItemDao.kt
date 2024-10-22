package com.example.assignment30

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientItemDao {
    @Query("SELECT * FROM patient_item_table")
    fun allPatientItems(): Flow<List<PatientItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPatientItem(patientItem: PatientItem)



}