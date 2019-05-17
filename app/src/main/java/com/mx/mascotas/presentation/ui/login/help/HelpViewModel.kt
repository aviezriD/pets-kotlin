package com.mx.mascotas.presentation.ui.login.help

import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.help.HelpUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class HelpViewModel(scheduleProvider: ScheduleProvider,
                    navigator: HelpContract.Navigator,
                    useCase: HelpUseCase):
    BaseViewModel<HelpContract.Navigator,HelpUseCase>(scheduleProvider,navigator,useCase) {
}