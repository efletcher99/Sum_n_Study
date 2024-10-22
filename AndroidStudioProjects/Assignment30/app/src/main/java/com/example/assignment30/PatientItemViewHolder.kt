package com.example.assignment30

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment30.databinding.PatientItemCellBinding

class PatientItemViewHolder(
    private val context: Context,
    private val binding: PatientItemCellBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bindPatientItem(patientItem: PatientItem){
            binding.name.text = patientItem.name
            binding.time.text = patientItem.time
        }
}