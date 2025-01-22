package com.example.recycle_view_test

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recycle_view_test.model.EmployeeRole
import com.example.recycle_view_test.model.EmployeeUIModel
import com.example.recycle_view_test.model.Gender
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import com.example.recycle_view_test.model.EmployeeInfo
import okhttp3.internal.format

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.input)
        val okButton = findViewById<Button>(R.id.button_ok)
        val employeeList = mutableListOf<EmployeeUIModel>()
        okButton.setOnClickListener(View.OnClickListener {
            val employeeCreator = EmployeeInfo(findViewById(R.id.ViewTop))
            val employee = employeeCreator.bind()
            employeeList.add(employee)
            employeeCreator.clear()
        })
        val cancel = findViewById<Button>(R.id.button_cancel)
        cancel.setOnClickListener(View.OnClickListener {
            setContentView(R.layout.activity_main)
            val employeeContainer = findViewById<LinearLayout>(R.id.employeeContainer)
            for(employee in employeeList){
                val employeeView = LayoutInflater.from(this).inflate(R.layout.item_employee, employeeContainer, false)
                val employeeViewHolder = EmployeeViewHolder(employeeView)
                employeeViewHolder.bindData(employee)
                employeeContainer.addView(employeeView)
            }
            val back = findViewById<Button>(R.id.Back)
            back.setOnClickListener(View.OnClickListener {
                setContentView(R.layout.input)
            })
        })

    }
}
