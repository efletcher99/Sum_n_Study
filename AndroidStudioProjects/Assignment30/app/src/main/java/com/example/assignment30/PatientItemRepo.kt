package com.example.assignment30

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
class PatientItemRepo(private val patientItemDao: PatientItemDao) {

    val allPatientItems: Flow<List<PatientItem>> = patientItemDao.allPatientItems()

    @WorkerThread
    suspend fun insertPatientItem(patientItem: PatientItem){
        patientItemDao.insertPatientItem(patientItem)
    }
}