package com.mx.mascotas.presentation.ui.login

import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.login.LoginUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class LoginViewModel(scheduleProvider: ScheduleProvider,
                     navigator: LoginContract.Navigator,
                     useCase: LoginUseCase) :
    BaseViewModel<LoginContract.Navigator, LoginUseCase>(
        scheduleProvider
        ,navigator
        ,useCase
    ) {
}