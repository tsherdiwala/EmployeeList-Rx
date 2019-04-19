package com.knoxpo.employee_rx

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(private val employeeList: List<Employee>) : RecyclerView.Adapter<EmployeeVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeVH {

        return EmployeeVH(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_employee,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount() = employeeList.size

    override fun onBindViewHolder(holder: EmployeeVH, position: Int) {
        holder.bindEmployee(employeeList[position])
    }
}