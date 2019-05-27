package com.mx.mascotas.presentation.ui.main.common.profile

import androidx.databinding.ObservableField
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.profile.ProfileUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class ProfileViewModel(scheduleProvider: ScheduleProvider,navigator: ProfileContract.Navigator,usecase: ProfileUseCase):
    BaseViewModel<ProfileContract.Navigator,ProfileUseCase>(scheduleProvider,navigator,usecase){


    var observableNombre = ObservableField<String>()
    var observableLastName = ObservableField<String>()
    var observableEmail = ObservableField<String>()
    var observableCedula = ObservableField<String>()
    var observablePhone = ObservableField<String>()


    init {
        traerDatosPerfil()
    }

    fun traerDatosPerfil (){

        compositeDisposable.add(
            useCase.getUserProfile()
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .subscribe({mandaInfo ->
                    observableNombre.set(mandaInfo.name)
                    observableLastName.set(mandaInfo.lastName)
                    observableEmail.set(mandaInfo.email)
                    observableCedula.set(mandaInfo.cedula)
                    observablePhone.set(mandaInfo.phone) },{
                    it.printStackTrace()

                })
        )

    }

}