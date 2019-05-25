package com.mx.mascotas.presentation.ui.login.registry

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.registry.RegistryUseCase
import com.mx.mascotas.presentation.base.BaseViewModel
import com.mx.mascotas.presentation.ui.utils.Constants

class RegistryViewModel(scheduleProvider: ScheduleProvider,
                        navigator: RegistryContract.Navigator,
                        useCase: RegistryUseCase):
    BaseViewModel<RegistryContract.Navigator,RegistryUseCase>(scheduleProvider,navigator,useCase),RegistryContract.ViewModel {

    var validatePassword = MutableLiveData<String>()
    var user = MutableLiveData<String>()
    var name = MutableLiveData<String>()
    var lastName = MutableLiveData<String>()
    var phone = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var result = MutableLiveData<Pair<Int,String>>()

    override fun register(user: String,email: String, pwd: String, pwd2: String, name: String,lastName: String,phone : String,type : Int) {
        resetFields()

        if (user.isNotEmpty()){
            if(pwd.isNotEmpty() && pwd2.isNotEmpty()){
                if (pwd.length > 6){
                    if (pwd == pwd2){
                        if (name.isNotEmpty()){
                            if (lastName.isNotEmpty()){
                                if (phone.isNotEmpty()){
                                    if (email.isNotEmpty()){
                                        val user = User(0,type,user = user ,name = name,lastName = lastName,phone = phone,email = email,password = pwd)
                                        compositeDisposable.add(
                                            useCase.register(user)
                                                .subscribeOn(scheduleProvider.io())
                                                .observeOn(scheduleProvider.ui())
                                                .subscribe({
                                                    if ( it){
                                                        result.value = Pair(0,Constants.REGISTRY.SUCCESS)
                                                    }else
                                                        result.value = Pair(0,Constants.REGISTRY.EXIST_USER)

                                                },{it.printStackTrace()
                                                    result.value = Pair(-1,"")
                                                    Log.e("RegistryViewModel","fail")
                                                }) )

                                    }else{
                                        this.email.value = Constants.REGISTRY.REQUIRED_FIELD
                                    }
                                }else
                                    this.phone.value = Constants.REGISTRY.REQUIRED_FIELD
                            }else
                                this.lastName.value = Constants.REGISTRY.REQUIRED_FIELD
                        }else{
                            this.name.value = Constants.REGISTRY.REQUIRED_FIELD
                        }

                    }else{
                        validatePassword.value = Constants.REGISTRY.DIFERENT_FIELD

                    }
                }else{
                    validatePassword.value = Constants.REGISTRY.INVALIDATE_FIELD
                }

            }else{
                validatePassword.value = Constants.REGISTRY.REQUIRED_FIELD
            }
        }else{
            this.user.value = Constants.REGISTRY.REQUIRED_FIELD
        }

    }

    private fun resetFields(){
        validatePassword.value = null
        user.value = null
        name.value = null
        email.value = null

    }

}