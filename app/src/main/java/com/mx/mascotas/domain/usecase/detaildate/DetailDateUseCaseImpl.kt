package com.mx.mascotas.domain.usecase.detaildate

import androidx.lifecycle.LiveData
import com.mx.mascotas.data.database.entity.Date
import com.mx.mascotas.domain.repository.DateRepository

class DetailDateUseCaseImpl(val dateRepository: DateRepository) : DetailDateUseCase{
    override fun getInfoDateById(id: Int): LiveData<Date> {
        return dateRepository.getInfoDateById(id)
    }
}