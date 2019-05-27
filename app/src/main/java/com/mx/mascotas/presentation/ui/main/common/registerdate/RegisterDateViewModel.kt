package com.mx.mascotas.presentation.ui.main.common.registerdate

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mx.mascotas.data.database.entity.CatService
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.registerdate.RegisterDateUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class RegisterDateViewModel (var schedule: ScheduleProvider, navigator: RegisterDateContract.Navigator,  useCase: RegisterDateUseCase) :
BaseViewModel<RegisterDateContract.Navigator, RegisterDateUseCase> (schedule, navigator, useCase),RegisterDateContract.ViewModel
{
    var listPet = ObservableArrayList<Pet>()
    var listService = ObservableArrayList<CatService>()
    var listVet = ObservableArrayList<User>()

    var listPetLive : LiveData<List<Pet>> = MutableLiveData()
    var listServiceLive : LiveData<List<CatService>>  = MutableLiveData()
    var listVetLive :LiveData<List<User>> = MutableLiveData()

    init {
        listPetLive = useCase.getListPet()
        listServiceLive = useCase.getListServices()
        listVetLive = useCase.getListVet()

    }

    override fun addPet(list: List<Pet>) {
        listPet.clear()
        listPet.addAll(list)
    }

    override fun addUser(list: List<User>) {
        listVet.clear()
        listVet.addAll(list)
    }

    override fun addCatService(list: List<CatService>) {
        listService.clear()
        listService.addAll(list)
    }
}