package com.example.assignment30

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.util.*

class PatientViewModel(private val repository: PatientItemRepo) : ViewModel() {

    var patientItems: LiveData<List<PatientItem>> = repository.allPatientItems.asLiveData()

    fun addPatientItem(newPatient: PatientItem) = viewModelScope.launch{
        repository.insertPatientItem(newPatient)
    }
}

class PatientItemModelFactory(private val repository: PatientItemRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PatientViewModel::class.java))
            return PatientViewModel(repository) as T

        throw java.lang.IllegalArgumentException("Bad class for view model")
    }
}