package com.mx.mascotas.data.repository

import io.reactivex.Scheduler

interface ScheduleProvider {
    fun ui() : Scheduler
    fun io() : Scheduler
}