package com.jedsada.workerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.firebase.jobdispatcher.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dispatcher = FirebaseJobDispatcher(GooglePlayDriver(this))
        dispatcher.cancelAll()
        val myJob = dispatcher.newJobBuilder()
            .setService(MyJobService::class.java)
            .setTag("my-unique-tag")
            .setRecurring(true)
            .setLifetime(Lifetime.UNTIL_NEXT_BOOT)
            .setReplaceCurrent(false)
            .setTrigger(Trigger.executionWindow(0, 60))
            .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
            .setConstraints(Constraint.ON_ANY_NETWORK)
            .build()
        dispatcher.mustSchedule(myJob)
    }
}
