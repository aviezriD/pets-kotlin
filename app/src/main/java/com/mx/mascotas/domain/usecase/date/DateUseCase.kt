package com.mx.mascotas.domain.usecase.date

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.Date

interface DateUseCase {
    fun getAgent(): LiveData<Date>
}