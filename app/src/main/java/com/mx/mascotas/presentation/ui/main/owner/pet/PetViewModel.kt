package com.mx.mascotas.presentation.ui.main.owner.pet

import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.pet.PetUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class PetViewModel(scheduleProvider: ScheduleProvider,navigator: PetContract.Navigator,usercase: PetUseCase):
BaseViewModel<PetContract.Navigator,PetUseCase>(scheduleProvider,navigator,usercase),PetContract.ViewModel{
}