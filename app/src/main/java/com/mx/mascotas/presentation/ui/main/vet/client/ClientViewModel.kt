package com.mx.mascotas.presentation.ui.main.vet.client

import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.client.ClientUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class ClientViewModel(scheduleProvider: ScheduleProvider, navigator: ClientContract.Navigator,useCase: ClientUseCase):
    BaseViewModel<ClientContract.Navigator,ClientUseCase> (scheduleProvider,navigator,useCase),ClientContract.ViewModel{
}