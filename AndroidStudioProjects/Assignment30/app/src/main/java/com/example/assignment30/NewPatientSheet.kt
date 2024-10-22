package com.example.assignment30

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.assignment30.databinding.FragmentNewPatientSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewPatientSheet(var patientItem: PatientItem?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewPatientSheetBinding
    private lateinit var patientViewModel: PatientViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (patientItem != null){
            binding.patientTitle.text = "Edit Patient"
            val editable = Editable.Factory.getInstance()
            binding.name.text = editable.newEditable(patientItem!!.name)
            binding.service.text = editable.newEditable(patientItem!!.service)
        }
        else {
            binding.patientTitle.text = "New Patient"
        }

        patientViewModel = ViewModelProvider(activity).get(PatientViewModel::class.java)
        binding.saveButton.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewPatientSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun saveAction(){
        val name = binding.name.text.toString()
        val service = binding.service.text.toString()
        val time = binding.time.text.toString()
        if(patientItem == null){
            val newPatient = PatientItem( name, service, time)
            patientViewModel.addPatientItem(newPatient)
        }
        else{
            patientItem!!.name = name
            patientItem!!.service = service
            patientItem!!.time = time
        }
        binding.name.setText("")
        binding.service.setText("")
        binding.time.setText("")
    }

}