package com.mx.mascotas.data.executor

import com.mx.mascotas.data.repository.ScheduleProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors

class AppScheduleProvider: ScheduleProvider {
    private val executor =  Executors.newFixedThreadPool( Runtime.getRuntime().availableProcessors() + 1)

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun io(): Scheduler {
        return Schedulers.from(executor)
    }
}