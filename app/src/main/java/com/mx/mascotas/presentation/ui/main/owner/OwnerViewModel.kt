package com.mx.mascotas.presentation.ui.main.owner

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.entity.ItemPet
import com.mx.mascotas.domain.usecase.owner.OwnerUseCase
import com.mx.mascotas.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OwnerViewModel(scheduleProvider: ScheduleProvider, navigator : OwnerContract.Navigator, useCase: OwnerUseCase):
    BaseViewModel<OwnerContract.Navigator,OwnerUseCase>(scheduleProvider,navigator,useCase), OwnerContract.ViewModel{
    private val viewModelJob = Job()
    private val scope = CoroutineScope(Dispatchers.IO + viewModelJob)

    var listPets : LiveData<List<ItemPet>> = MutableLiveData<List<ItemPet>>()
    val pets = ObservableArrayList<ItemPet>()
    val msj = MutableLiveData<String>()
    val enable = ObservableBoolean(true)

    init {
        listPets = useCase.getListPetByNameMinimal()
    }

    override fun addPets(list: List<ItemPet>) {
        pets.clear()
        pets.addAll(list)
        if (list.isNotEmpty()){
            enable.set(false)
        }else
            enable.set(true)
    }

    override fun deletePet(id: String) {
        scope.launch {
            useCase.deletePet(id)
        }
    }
}