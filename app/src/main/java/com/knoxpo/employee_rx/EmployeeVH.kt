package com.knoxpo.employee_rx

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val employeeNameTV = itemView.findViewById<TextView>(R.id.employeeNameTV)
    private val employeeSalaryTV = itemView.findViewById<TextView>(R.id.employeeSalaryTV)

    fun bindEmployee(employee: Employee) {
        employeeNameTV.text = employee.employeeName
        employeeSalaryTV.text = employee.employeeSalary
    }

}