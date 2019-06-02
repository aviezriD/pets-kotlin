package com.mx.mascotas.presentation.ui.login.sign

import androidx.lifecycle.MutableLiveData
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.sign.SignUseCase
import com.mx.mascotas.presentation.base.BaseViewModel
import com.mx.mascotas.presentation.ui.utils.Constants

class SignViewModel(scheduleProvider: ScheduleProvider
                    ,navigator: SignContract.Navigator,
                    useCase: SignUseCase):
    BaseViewModel<SignContract.Navigator,SignUseCase>(scheduleProvider,navigator,useCase), SignContract.ViewModel {

    val user = MutableLiveData<String>()
    val pwd = MutableLiveData<String>()
    val result = MutableLiveData<Pair<Int, String>>()

    override fun login(user: String, pwd: String, type: Int) {
        this.user.value = null
        this.pwd.value = null

        if (user.isNotEmpty()){
            if (pwd.isNotEmpty()){
                    compositeDisposable.add(
                        useCase.login(user,pwd,type)
                            .subscribeOn(scheduleProvider.io())
                            .observeOn(scheduleProvider.ui())
                            .subscribe({
                                when(it){
                                    0 -> result.value = Pair(it,Constants.SIGN.NO_EXIST_USER) //no exits user
                                    1 -> result.value = Pair(it,"") // succes login
                                    else -> result.value = Pair(it,Constants.SIGN.INCORRECT_PASSWORD) //  incorrect password
                                }
                            },{it.printStackTrace()
                                result.value = Pair(-1,Constants.SIGN.ERROR)
                            })
                    )
            }else
                this.pwd.value = Constants.SIGN.REQUIRED_FIELD
        }else
            this.user.value = Constants.SIGN.REQUIRED_FIELD
    }
}