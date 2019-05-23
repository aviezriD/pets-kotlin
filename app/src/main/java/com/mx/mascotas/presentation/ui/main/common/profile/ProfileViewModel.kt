package com.mx.mascotas.presentation.ui.main.common.profile

import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.profile.ProfileUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class ProfileViewModel(scheduleProvider: ScheduleProvider,navigator: ProfileContract.Navigator,usecase: ProfileUseCase):
    BaseViewModel<ProfileContract.Navigator,ProfileUseCase>(scheduleProvider,navigator,usecase){
}