package com.mx.mascotas.presentation.ui.main.owner.pet

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.mx.mascotas.data.database.entity.CatPet
import com.mx.mascotas.data.database.entity.CatPetSize
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.pet.PetUseCase
import com.mx.mascotas.presentation.base.BaseViewModel
import com.mx.mascotas.presentation.ui.utils.Constants
import com.mx.mascotas.presentation.ui.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*

class PetViewModel(scheduleProvider: ScheduleProvider,navigator: PetContract.Navigator,usercase: PetUseCase):
BaseViewModel<PetContract.Navigator,PetUseCase>(scheduleProvider,navigator,usercase),PetContract.ViewModel{
    private val viewModelJob = Job()
    private val scope = CoroutineScope(Dispatchers.IO + viewModelJob)

    val catPet = ObservableArrayList<CatPet>()


    val catPetSize = ObservableArrayList<CatPetSize>()

    var listCatPat : LiveData<List<CatPet>> = MutableLiveData()

    var listCatPatSize : LiveData<List<CatPetSize>> = MutableLiveData()
    var petEdit: LiveData<Pet> = MutableLiveData()

    val userLiveData = MutableLiveData<String>()
    val raceLiveData = MutableLiveData<String>()
    val colorLiveData = MutableLiveData<String>()
    val weightLiveData = MutableLiveData<String>()
    val sizeTypeLiveData = MutableLiveData<String>()
    val typeLiveData = MutableLiveData<String>()
    val allergyLiveData = MutableLiveData<String>()
    val dateBornLiveData = MutableLiveData<String>()
    val signsLiveData = MutableLiveData<String>()
    val idEdith = MutableLiveData<String>()

    val selectionType = ObservableInt()
    val selectionTypeSize = ObservableInt()


    init {
        listCatPat = usercase.getTypePet()
        listCatPatSize = usercase.getListCatPetSize()
        petEdit = Transformations.switchMap(idEdith){ id -> usercase.getPetById(id) }
    }

    override fun setIndices(index: Int, index2: Int) {
        selectionType.set(index)
        selectionTypeSize.set(index)
    }

    override fun getPetById(id: String) {
        idEdith.value = id
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private fun reset(){
        userLiveData.value = null
        raceLiveData.value = null
        colorLiveData.value = null
        weightLiveData.value = null
        sizeTypeLiveData.value = null
        typeLiveData.value = null
        allergyLiveData.value = null
        dateBornLiveData.value = null
        signsLiveData.value = null
    }

    override fun addCatType(list: List<CatPet>) {
        catPet.clear()
        catPet.addAll(list)
    }

    override fun addCatTypeSize(list: List<CatPetSize>) {
        catPetSize.clear()
        catPetSize.addAll(list)
    }

    override fun register(
        name: String,
        race: String,
        weight: String,
        sizeType: Int,
        type: Int,
        sex: Boolean,
        allergy: String,
        dateBorn: String,
        signs: String,
        photo: String
    ) {

        if (type == -1){
            navigator.showMessage(Constants.PET_REGISTRY.REQUIRED_SELECT)
            return
        }

        reset()

        if ( name.isEmpty()){
            userLiveData.value = Constants.PET_REGISTRY.REQUIRED_FIELD
            return
        }
        if ( race.isEmpty()){
            raceLiveData.value = Constants.PET_REGISTRY.REQUIRED_FIELD
            return
        }

        if ( weight.isEmpty()){
            weightLiveData.value = Constants.PET_REGISTRY.REQUIRED_FIELD
            return
        }
        var date : Date?
        if ( dateBorn.isEmpty()){
            dateBornLiveData.value = Constants.PET_REGISTRY.REQUIRED_FIELD
            return
        }else{
            date = Utils.stringToDate(dateBorn)
        }

        if ( signs.isEmpty()){
            signsLiveData.value = Constants.PET_REGISTRY.REQUIRED_FIELD
            return
        }
        if ( allergy.isEmpty()){
            allergyLiveData.value = Constants.PET_REGISTRY.REQUIRED_FIELD
            return
        }

        scope.launch {
            val pet = Pet("",name,race,weight.toFloat(),type,sex,sizeType,allergy,date?.time ?: 0,signs,photo,"")
            useCase.register(pet)
        }
        navigator.success()
    }

}