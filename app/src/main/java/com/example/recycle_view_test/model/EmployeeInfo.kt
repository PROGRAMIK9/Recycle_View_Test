package com.example.recycle_view_test.model

import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.recycle_view_test.EmployeeViewHolder
import com.example.recycle_view_test.R

class EmployeeInfo(containerView:View){
    private val name: TextView by lazy { containerView.findViewById(R.id.Name) }
    private val role: RadioGroup by lazy { containerView.findViewById(R.id.Role) }
    private val bio: TextView by lazy { containerView.findViewById(R.id.Bio) }
    private val gender:RadioGroup by lazy{containerView.findViewById(R.id.Gender)}
    private val url: TextView by lazy { containerView.findViewById(R.id.URL) }
    private val container = containerView
    fun bind(): EmployeeUIModel {
        val employeeUI = EmployeeUIModel("","",EmployeeRole.HumanResources,Gender.Others,"")
        employeeUI.name = name.text.toString()
        var selectedGender: String = ""
        val select = gender.checkedRadioButtonId
        if(select != -1){
            val selectedRadioButton = container.findViewById<RadioButton>(select)
            selectedGender = selectedRadioButton.text.toString()
        }
        if (selectedGender == "Male") {
            employeeUI.gender = Gender.Male
        } else if (selectedGender == "Female") {
            employeeUI.gender = Gender.Female
        } else {
            employeeUI.gender = Gender.Others
        }
        var selectedRole = ""
        val selectR = role.checkedRadioButtonId
        if(selectR != -1){
            val selectedRadioButton = container.findViewById<RadioButton>(selectR)
            selectedRole = selectedRadioButton.text.toString()
        }
        if (selectedRole == "HUMAN RESOURCE") {
            employeeUI.role = EmployeeRole.HumanResources
        } else if (selectedGender == "SECURITY") {
            employeeUI.role = EmployeeRole.Security
        } else {
            employeeUI.role = EmployeeRole.Technology
        }
        employeeUI.biography = bio.text.toString()
        employeeUI.imageUrl = url.text.toString()
        return employeeUI
    }
    fun clear(){
        name.text=""
        bio.text=""
        url.text=""

    }
}