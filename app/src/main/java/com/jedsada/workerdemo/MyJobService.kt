package com.jedsada.workerdemo

import android.util.Log
import com.firebase.jobdispatcher.JobParameters
import com.firebase.jobdispatcher.JobService
import java.text.DateFormat
import java.util.*

class MyJobService : JobService() {

    override fun onStartJob(job: JobParameters): Boolean {
        val currentTime = DateFormat.getDateTimeInstance().format(Date())
        Log.d("POND", "onStartJob current time: $currentTime")
        return false
    }

    override fun onStopJob(job: JobParameters): Boolean {
        Log.d("POND", "onStopJob")
        return false
    }
}