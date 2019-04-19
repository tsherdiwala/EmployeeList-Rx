package com.knoxpo.employee_rx

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface EmployeeApi {

    @GET("employees")
    fun getEmployees(): Single<List<Employee>>

    companion object {

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://dummy.restapiexample.com/api/v1/")
            .build()

    }

}