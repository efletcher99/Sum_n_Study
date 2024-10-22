package com.example.assignment30

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "patient_item_table")
class PatientItem(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "service") var service: String,
    @ColumnInfo(name = "time") var time: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0)
{
}