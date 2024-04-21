package com.cam.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import kotlin.random.Random

class StudentProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_profile)

        val imageId = intent.getIntExtra("IMAGE_ID", 0)
        val name = intent.getStringExtra("NAME")
        val idNumber = intent.getIntExtra("ID_NUMBER", 0)
        val program = intent.getStringExtra("PROGRAM")

        val imageView = findViewById<ImageView>(R.id.images)
        val nameTextView = findViewById<TextView>(R.id.name)
        val idNumberTextView = findViewById<TextView>(R.id.idNumber)
        val programTextView = findViewById<TextView>(R.id.program)

        imageView.setImageResource(imageId)
        nameTextView.text = name
        idNumberTextView.text = idNumber.toString()
        programTextView.text = program

        val listView = findViewById<ListView>(R.id.listView)
        val subjectsList = mutableListOf<SubjectGrades>()

        val subjects = arrayOf("CC-TECHNO32", "IT-ELBIZAN2", "IT-FREDTHINK", "IT-IMDBSYS32","IT-INFOSEC32","IT-INTPROG32","IT-SYSADMN32", "IT-SYSARCH32")
        for (subject in subjects) {
            val randomGrade = String.format("%.1f", Random.nextDouble(1.0, 5.0)).toDouble()
            val passOrFail = if (randomGrade > 3.0) "Fail" else "Pass"
            subjectsList.add(SubjectGrades(subject, randomGrade, passOrFail))
        }




        val adapter = SubjectGradesAdapter(this, subjectsList)
        listView.adapter = adapter

    }

}