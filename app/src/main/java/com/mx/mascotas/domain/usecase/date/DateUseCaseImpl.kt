package com.mx.mascotas.domain.usecase.date

import androidx.lifecycle.LiveData
import com.mx.mascotas.domain.entity.ItemDate
import com.mx.mascotas.domain.repository.DateRepository
import com.mx.mascotas.domain.repository.PreferenceRepository

class DateUseCaseImpl(val dateRepository: DateRepository,val preferenceRepository: PreferenceRepository): DateUseCase{
    override fun datadetails(): LiveData<List<ItemDate>> {
        return dateRepository.getListDatebyUser(preferenceRepository.getUserName())
    }

    override fun getDatePending(): LiveData<List<ItemDate>> {
        return dateRepository.getListDateendingPbyUser(preferenceRepository.getUserName())
    }
}