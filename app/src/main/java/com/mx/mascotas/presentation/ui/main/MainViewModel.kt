package com.mx.mascotas.presentation.ui.main

import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.main.MainUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class MainViewModel(scheduleProvider: ScheduleProvider,
                    navigator: MainContract.Navigator,
                    useCase: MainUseCase):
    BaseViewModel<MainContract.Navigator,MainUseCase>(scheduleProvider,navigator,useCase) {
}