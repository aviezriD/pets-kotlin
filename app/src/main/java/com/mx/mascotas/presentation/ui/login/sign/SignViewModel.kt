package com.mx.mascotas.presentation.ui.login.sign

import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.sign.SignUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class SignViewModel(scheduleProvider: ScheduleProvider
                    ,navigator: SignContract.Navigator,
                    useCase: SignUseCase):
    BaseViewModel<SignContract.Navigator,SignUseCase>(scheduleProvider,navigator,useCase) {
}