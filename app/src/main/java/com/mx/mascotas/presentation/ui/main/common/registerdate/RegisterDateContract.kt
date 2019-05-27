package com.mx.mascotas.presentation.ui.main.common.registerdate

import com.mx.mascotas.data.database.entity.CatService
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.database.entity.User

interface RegisterDateContract {
    interface Navigator {
    }

    interface ViewModel{
        fun addPet(list: List<Pet>)
        fun addUser(list: List<User>)
        fun addCatService(list: List<CatService>)
    }
}