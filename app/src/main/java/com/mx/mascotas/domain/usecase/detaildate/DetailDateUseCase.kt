package com.mx.mascotas.domain.usecase.detaildate

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.Date

interface DetailDateUseCase {
    fun getInfoDateById(id: Int): LiveData<Date>
}