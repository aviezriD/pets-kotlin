package com.mx.mascotas.presentation.ui.main.owner

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.entity.ItemPet
import com.mx.mascotas.domain.usecase.owner.OwnerUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class OwnerViewModel(scheduleProvider: ScheduleProvider, navigator : OwnerContract.Navigator, useCase: OwnerUseCase):
    BaseViewModel<OwnerContract.Navigator,OwnerUseCase>(scheduleProvider,navigator,useCase), OwnerContract.ViewModel{
    var listPets : LiveData<List<ItemPet>> = MutableLiveData<List<ItemPet>>()
    val pets = ObservableArrayList<ItemPet>()

    init {
        listPets = useCase.getListPetByNameMinimal()
    }

    override fun addPets(list: List<ItemPet>) {
        pets.clear()
        pets.addAll(list)
    }
}