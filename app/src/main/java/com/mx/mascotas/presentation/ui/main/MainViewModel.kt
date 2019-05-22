package com.mx.mascotas.presentation.ui.main

import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.main.MainUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class MainViewModel(scheduleProvider: ScheduleProvider,
                    navigator: MainContract.Navigator,
                    useCase: MainUseCase):
    BaseViewModel<MainContract.Navigator,MainUseCase>(scheduleProvider,navigator,useCase) {

    init {
        compositeDisposable.add(
            useCase.getUser()
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .subscribe({
                    if ( it.idRole == 0)
                        typeMenu.set(true)
                    else
                        typeMenu.set(true)
                    user.set(it)
                },{

                })
        )
    }

    val typeMenu = ObservableBoolean()
    val user = ObservableField<User>()
}