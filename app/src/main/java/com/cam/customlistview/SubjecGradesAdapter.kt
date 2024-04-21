package com.cam.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SubjectGradesAdapter(
    context: Context,
    private val subjectGradesList: List<SubjectGrades>
) : ArrayAdapter<SubjectGrades>(context, 0, subjectGradesList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.subject_grades_item, parent, false)
        }

        val currentSubjectGrade = getItem(position)

        val subjectTextView = listItemView!!.findViewById<TextView>(R.id.subject)
        val gradesTextView = listItemView.findViewById<TextView>(R.id.grades)
        val passOrFailTextView = listItemView.findViewById<TextView>(R.id.passOrFail)

        subjectTextView.text = currentSubjectGrade?.subject
        gradesTextView.text = currentSubjectGrade?.grades.toString()
        passOrFailTextView.text = currentSubjectGrade?.passOrFail

        return listItemView
    }
}
