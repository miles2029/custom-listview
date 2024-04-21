package com.cam.customlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var customAdapter: StudentCustomListView.CustomAdapter
    private lateinit var listView: ListView
    private val studentDetails = mutableListOf<StudentDetails>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        studentDetails.add(StudentDetails(R.drawable.aang, "Aang", 111, "BSIT"))
        studentDetails.add(StudentDetails(R.drawable.katara, "Katara", 222, "BSIT"))
        studentDetails.add(StudentDetails(R.drawable.sokka, "Sokka", 333, "BSIT"))
        studentDetails.add(StudentDetails(R.drawable.suki, "Suki", 444, "BSIT"))
        studentDetails.add(StudentDetails(R.drawable.toph, "Toph", 555, "BSIT"))

        customAdapter = StudentCustomListView.CustomAdapter(this, studentDetails)
        listView.adapter = customAdapter



        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedStudent = studentDetails[position]
            val intent = Intent(this@MainActivity, StudentProfile::class.java).apply {
                putExtra("IMAGE_ID", selectedStudent.image)
                putExtra("NAME", selectedStudent.name)
                putExtra("ID_NUMBER", selectedStudent.idNumber)
                putExtra("PROGRAM", selectedStudent.program)
            }

            startActivity(intent)
        }
    }
}

