package com.mx.mascotas.presentation.ui.main.vet.date

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mx.mascotas.data.database.entity.Date
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.date.DateUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class DateViewModel( scheduleProvider: ScheduleProvider,navigator: DateContract.Navigator, usecase: DateUseCase):
    BaseViewModel<DateContract.Navigator,DateUseCase>(scheduleProvider,navigator,usecase),DateContract.ViewModel{

    val listObserver =  ObservableArrayList<Date>()
    val list: LiveData<Date> =  MutableLiveData()

    init {

    }

}