package com.mx.mascotas.presentation.ui.main.common.detaildate

import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.mx.mascotas.data.database.entity.Date
import com.mx.mascotas.data.repository.ScheduleProvider
import com.mx.mascotas.domain.usecase.detaildate.DetailDateUseCase
import com.mx.mascotas.presentation.base.BaseViewModel

class DetailDateViewModel(scheduleProvider: ScheduleProvider,navigator: DetailDateContract.Navigator,useCase: DetailDateUseCase):
    BaseViewModel<DetailDateContract.Navigator,DetailDateUseCase>(scheduleProvider,navigator,useCase),DetailDateContract.ViewModel{

    val data = ObservableArrayMap<String,Any>().apply {
        put("service", "consulta")
        put("subservice", "Inc.")
        put("pet", "")
        put("type", "")
        put("obs", "")
    }

    val  id = MutableLiveData<Int>()
    val date = Transformations.switchMap(id) { id -> useCase.getInfoDateById(id)} ?: MutableLiveData()
    val field = ObservableField<String>()
    val field2 = ObservableField<String>()
    val field3 = ObservableField<String>()

    override fun setData(date: Date) {
        data.apply {
            val type = when(date.idPet){
                0 -> "Perro"
                1 -> "Gato"
                else -> "Otro"
            }
            put("service", date.typeService)
            put("subservice", date.typeSubservice)
            put("pet", date.namePet)
            put("type",type )

            setTitle(date.typeService)
        }
    }

    private fun setTitle(service : String){
        when(service){
            "Veterinario" ->{field.set("Diagnóstico");field2.set("Medicamento/Recomendaciones");field3.set("Proxima consulta")}
            "Higiene" ->{field.set("Productos utlizados");field2.set("Recomendaciones");field3.set("Proximo baño")}
            else ->{field.set("Número de serie de la vacuna");field2.set("Recomendaciones");field3.set("Proxima vacuna")}
        }
    }
}