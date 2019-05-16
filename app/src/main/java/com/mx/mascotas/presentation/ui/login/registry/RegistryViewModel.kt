package com.mx.mascotas.presentation.ui.login.registry

import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.registry.RegistryUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class RegistryViewModel(scheduleProvider: ScheduleProvider,
                        navigator: RegistryContract.Navigator,
                        useCase: RegistryUseCase):
    BaseViewModel<RegistryContract.Navigator,RegistryUseCase>(scheduleProvider,navigator,useCase) {
}