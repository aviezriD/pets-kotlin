package com.mx.mascotas.presentation.ui.main.common.registerdate

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.vision.L
import com.mx.mascotas.data.database.entity.*
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.registerdate.RegisterDateUseCase
import com.mx.mascotas.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegisterDateViewModel (schedule: ScheduleProvider, navigator: RegisterDateContract.Navigator,  useCase: RegisterDateUseCase) :
BaseViewModel<RegisterDateContract.Navigator, RegisterDateUseCase> (schedule, navigator, useCase),RegisterDateContract.ViewModel
{   private val viewModelJob = Job()
    private val scope = CoroutineScope(Dispatchers.IO + viewModelJob)

    var listPet = ObservableArrayList<Pet>()
    var listService = ObservableArrayList<CatService>()
    var listVet = ObservableArrayList<User>()
    var listVetDay = ObservableArrayList<CatVetDia>()
    var listVetHour = ObservableArrayList<CatVetHoras>()

    var listPetLive : LiveData<List<Pet>> = MutableLiveData()
    var listServiceLive : LiveData<List<CatService>>  = MutableLiveData()
    var listVetLive :LiveData<List<User>> = MutableLiveData()
    var listVetDayLive :LiveData<List<CatVetDia>> = MutableLiveData()
    var listVetHourLive :LiveData<List<CatVetHoras>> = MutableLiveData()

    init {
        listPetLive = useCase.getListPet()
        listServiceLive = useCase.getListServices()
        listVetLive = useCase.getListVet()

        listVetDayLive = useCase.getListCatVetDia()
        listVetHourLive = useCase.getListCatVetHoras()

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

    override fun addCatVetHoras(list: List<CatVetHoras>) {
        listVetHour.clear()
        listVetHour.addAll(list)
    }

    override fun addCatVetDia(list: List<CatVetDia>) {
        listVetDay.clear()
        listVetDay.addAll(list)
    }

    override fun registerDate(
        idPet: Int,
        namePet: String,
        typerService: String,
        subType: String,
        nameVet: String,
        location: String,
        date: String,
        hour: String,
        description: String
    ) {
        val date = Date(idPet = idPet,namePet = namePet, typeService =  typerService, typeSubservice = subType,
        nameVeterinarian = "kota",locationVeterinarian = "Naranjo número 447", date = java.util.Date().time,
            hour = java.util.Date().hours.toLong(),description = description ,estatus = 0,id = "",idRol = 1,idUser = "")
        scope.launch {
            useCase.insert(date)
        }
    }
}