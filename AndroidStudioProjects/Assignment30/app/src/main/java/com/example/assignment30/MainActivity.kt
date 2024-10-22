package com.example.assignment30

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment30.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val patientViewModel: PatientViewModel by viewModels {
        PatientItemModelFactory((application as AssignmentThree).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.newPatientButton.setOnClickListener {
            NewPatientSheet(null).show(supportFragmentManager, "newPatientTag")
        }
        setRecyclerView()

        val webIntent: Intent = Uri.parse("https://calendar.google.com/calendar/").let {webpage ->
            Intent(Intent.ACTION_VIEW, webpage)

        }
        findViewById<FloatingActionButton>(R.id.calendarsButton).setOnClickListener {
            startActivity(webIntent);
        }
    }
    private fun setRecyclerView(){
        val mainActivity = this
        patientViewModel.patientItems.observe(this){
            binding.patientListRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = it?.let { it1 -> PatientItemAdapter(it1) }
            }
        }
    }
}