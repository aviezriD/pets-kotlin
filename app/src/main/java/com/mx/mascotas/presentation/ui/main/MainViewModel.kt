package com.mx.mascotas.presentation.ui.main

import android.util.Log
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


    val typeMenu = ObservableBoolean()
    val user = ObservableField<User>()

    init {

//        android.os.Handler().postDelayed(Runnable { Log.i("menu ","change") ;typeMenu.set(true)},8000)
        compositeDisposable.add(
            useCase.getUser()
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .subscribe({
                    if ( it.idRole == 0){
                        typeMenu.set(true)
                        Log.i("menu ","true")
                    }
                    else{
                        typeMenu.set(false)
                        Log.i("menu ","false")
                    }
                    user.set(it)
                },{
                    it.printStackTrace()
                })
        )
    }

}