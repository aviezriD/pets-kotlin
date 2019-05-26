package com.mx.mascotas.presentation.ui.main.owner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.owner.OwnerUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class OwnerViewModel(scheduleProvider: ScheduleProvider, navigator : OwnerContract.Navigator, useCase: OwnerUseCase):
    BaseViewModel<OwnerContract.Navigator,OwnerUseCase>(scheduleProvider,navigator,useCase), OwnerContract.ViewModel{
    val listPets : LiveData<Pet> = MutableLiveData<Pet>()


}