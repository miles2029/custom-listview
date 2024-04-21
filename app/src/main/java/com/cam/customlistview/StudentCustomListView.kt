package com.cam.customlistview

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class StudentCustomListView : AppCompatActivity() {

    class CustomAdapter(val activity: Activity, val list: List<StudentDetails>) :
        ArrayAdapter<StudentDetails>(activity, R.layout.activity_student_custom_list_view) {

        override fun getCount(): Int {
            return list.size
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var itemView = convertView
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.activity_student_custom_list_view, parent, false)

            val images = itemView.findViewById<ImageView>(R.id.images)
            val name = itemView.findViewById<TextView>(R.id.name)
            val idNumber = itemView.findViewById<TextView>(R.id.idNumber)
            val program = itemView.findViewById<TextView>(R.id.program)

            val currentItem = list[position]
            program.text = currentItem.program
            name.text = currentItem.name
            idNumber.text = currentItem.idNumber.toString()
            images.setImageResource(currentItem.image)


            return itemView
        }
    }

}