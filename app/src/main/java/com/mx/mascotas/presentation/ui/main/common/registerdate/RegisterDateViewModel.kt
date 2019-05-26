package com.mx.mascotas.presentation.ui.main.common.registerdate

import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.registerdate.RegisterDateUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class RegisterDateViewModel (var schedule: ScheduleProvider, navigator: RegisterDateContract.Navigator,  useCase: RegisterDateUseCase) :
BaseViewModel<RegisterDateContract.Navigator, RegisterDateUseCase> (schedule, navigator, useCase)
{

}