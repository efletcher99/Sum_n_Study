package com.example.assignment30

import android.app.Application

class AssignmentThree:  Application(){
    private val database by lazy { PatientItemDatabase.getDatabase(this) }
    val repository by lazy { PatientItemRepo(database.patientItemDao())}
}