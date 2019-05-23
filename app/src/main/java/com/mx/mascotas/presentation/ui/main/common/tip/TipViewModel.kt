package com.mx.mascotas.presentation.ui.main.common.tip

import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.tip.TipUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class TipViewModel(scheduleProvider: ScheduleProvider,navigator: TipContract.Navigator, usecase: TipUseCase): BaseViewModel<TipContract.Navigator,TipUseCase>(scheduleProvider,navigator,usecase),TipContract.ViewModel {
}