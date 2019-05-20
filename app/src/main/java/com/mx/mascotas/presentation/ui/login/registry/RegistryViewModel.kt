package com.mx.mascotas.presentation.ui.login.registry

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.registry.RegistryUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class RegistryViewModel(scheduleProvider: ScheduleProvider,
                        navigator: RegistryContract.Navigator,
                        useCase: RegistryUseCase):
    BaseViewModel<RegistryContract.Navigator,RegistryUseCase>(scheduleProvider,navigator,useCase),RegistryContract.ViewModel {

    val validate = ObservableField<String>()
    val mutable = MutableLiveData<String>()

    override fun register(user: String,email: String, pwd: String, pwd2: String, name: String) {
        if (pwd == pwd2){
            val user = User(0,0,user = user ,name = name,email = email,password = pwd)
            Log.i("RegistryViewModel",Gson().toJson(user))
            compositeDisposable.add(
                useCase.register(user)
                    .subscribeOn(scheduleProvider.io())
                    .observeOn(scheduleProvider.ui())
                    .subscribe({
                        Log.i("RegistryViewModel","success")
                    },{
                        it.printStackTrace()
                        Log.e("RegistryViewModel","fail")
                    })
            )
        }else{
            mutable.value= "Los campos son diferentes"
            Log.i("RegistryViewModel","entra")
        }

    }

    override fun validate(msg: String, id: Int) {
        validate.set(msg)
    }
}