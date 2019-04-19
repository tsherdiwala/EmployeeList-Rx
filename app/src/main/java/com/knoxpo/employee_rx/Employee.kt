package com.knoxpo.employee_rx

import com.google.gson.annotations.SerializedName

//{
// "id":"432","employee_name":"-6371279747355484001test","employee_salary":"123","employee_age":"23","profile_image":""
// }

data class Employee(
    val id: String,

    @SerializedName("employee_name")
    val employeeName: String,

    @SerializedName("employee_salary")
    val employeeSalary: String,

    @SerializedName("employee_age")
    val employeeAge: String
)