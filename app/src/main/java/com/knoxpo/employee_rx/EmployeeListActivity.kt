package com.knoxpo.employee_rx

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_employee_list.*

private val TAG = EmployeeListActivity::class.java.simpleName

class EmployeeListActivity : AppCompatActivity() {

    private var apiDisposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_list)

        employeeRV.layoutManager = LinearLayoutManager(this)

        apiDisposable = EmployeeApi.retrofit
            .create(EmployeeApi::class.java)
            .getEmployees()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d(TAG, "Got Employee list: $it")
                    employeeRV.adapter = EmployeeAdapter(it)
                },
                {
                    Log.e(TAG, "Error in getting employee list", it)
                }
            )

    }

    override fun onDestroy() {
        apiDisposable?.dispose()
        super.onDestroy()
    }
}