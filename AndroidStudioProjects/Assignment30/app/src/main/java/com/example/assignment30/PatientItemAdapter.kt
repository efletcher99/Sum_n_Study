package com.example.assignment30

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment30.databinding.PatientItemCellBinding

class PatientItemAdapter(private val patientItems: List<PatientItem>
) : RecyclerView.Adapter<PatientItemViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = PatientItemCellBinding.inflate(from, parent, false)
        return PatientItemViewHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: PatientItemViewHolder, position: Int) {
        holder.bindPatientItem(patientItems[position])
    }

    override fun getItemCount(): Int = patientItems.size

}