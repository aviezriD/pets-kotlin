package com.mx.mascotas.presentation.ui.main.vet.history

import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.history.HistoryUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class HistoryViewModel(scheduleProvider: ScheduleProvider,navigator: HistoryContract.Navigator,usecase: HistoryUseCase):
    BaseViewModel<HistoryContract.Navigator,HistoryUseCase>(scheduleProvider,navigator,usecase),HistoryContract.ViewModel {
}