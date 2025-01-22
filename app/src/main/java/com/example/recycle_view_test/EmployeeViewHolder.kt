package com.example.recycle_view_test

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.recycle_view_test.model.EmployeeRole
import com.example.recycle_view_test.model.EmployeeUIModel
import com.example.recycle_view_test.model.Gender
import coil.load
private val Female_SYMBOL by lazy {
    HtmlCompat.fromHtml("&#9793", HtmlCompat.FROM_HTML_MODE_LEGACY)
}

private val Male_SYMBOL by lazy {
    HtmlCompat.fromHtml("&#9794", HtmlCompat.FROM_HTML_MODE_LEGACY)
}

private const val others_symbol = "?"

class EmployeeViewHolder(
    containerView: View
) : ViewHolder(containerView) {
    private val employeeNameView: TextView by lazy { containerView.findViewById(R.id.EmployeeName) }
    private val employeeRoleView: TextView by lazy { containerView.findViewById(R.id.EmployeeRole) }
    private val employeeBioView: TextView by lazy { containerView.findViewById(R.id.EmployeeBio) }
    private val employeeGenderView: TextView by lazy { containerView.findViewById(R.id.EmployeeGender) }
    private val employeePhotoView: ImageView by lazy { containerView.findViewById(R.id.View1) }

    fun bindData(employeeData: EmployeeUIModel) {
        val imageUrl = employeeData.imageUrl
        employeePhotoView.load(imageUrl) {
            placeholder(R.drawable.ic_launcher_background)
            error(R.drawable.ic_launcher_foreground)
        }
        employeeNameView.text=employeeData.name
        employeeRoleView.text = when(employeeData.role){
            EmployeeRole.HumanResources->"Human Resources"
            EmployeeRole.Security->"Security"
            EmployeeRole.Technology->"Technology"
        }
        employeeBioView.text =  employeeData.biography
        employeeGenderView.text = when(employeeData.gender){
            Gender.Male-> Male_SYMBOL
            Gender.Female-> Female_SYMBOL
            Gender.Others-> others_symbol
        }

    }
}