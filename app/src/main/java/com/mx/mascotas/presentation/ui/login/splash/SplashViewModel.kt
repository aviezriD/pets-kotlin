package com.mx.mascotas.presentation.ui.login.splash

import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.splash.SplashUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class SplashViewModel(scheduleProvider: ScheduleProvider,
                      navigator: SplashContract.Navigator,
                      useCase: SplashUseCase) :
    BaseViewModel<SplashContract.Navigator, SplashUseCase>(
        scheduleProvider
        ,navigator
        ,useCase
    )  {
}