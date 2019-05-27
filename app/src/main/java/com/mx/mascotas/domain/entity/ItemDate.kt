package com.mx.mascotas.domain.entity

import com.mx.mascotas.data.database.entity.CatSubService
import com.mx.mascotas.presentation.ui.utils.Utils
import java.lang.Exception

data class ItemDate(var id : Int,
                    var idPet: Int,
                     var namePet : String,
                    var hour : String,
                    var date : String,
                    var typeService : String,
                    var typeSubservice: String,
                    var idUser: Int,
                    var name: String,
                    var nameVeterinarian: String,
                    var locationVeterinarian: String,
                    var estatus :Int) {

    fun getFormatDate(): String{
        val result = try {
            Utils.longToDate(date.toLong())
        }catch (e: Exception){""}
        return result
    }

    fun getFormatHour(): String{
        val result = try {
            Utils.longToHour(hour.toLong())
        }catch (e: Exception){""}
        return result
    }

}