package com.mx.mascotas.presentation.ui.main.common.registerdate

import com.mx.mascotas.data.database.entity.*

interface RegisterDateContract {
    interface Navigator {
    }

    interface ViewModel{
        fun addPet(list: List<Pet>)
        fun addUser(list: List<User>)
        fun addCatService(list: List<CatService>)
        fun addCatVetHoras(list: List<CatVetHoras>)
        fun addCatVetDia(list: List<CatVetDia>)
        fun registerDate(idPet : Int, namePet : String, typerService : String, subType : String,nameVet: String, location : String, date: String, hour : String, description : String)
    }
}