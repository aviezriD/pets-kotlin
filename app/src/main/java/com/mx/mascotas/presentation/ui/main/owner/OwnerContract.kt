package com.mx.mascotas.presentation.ui.main.owner

import com.mx.mascotas.domain.entity.ItemPet

interface OwnerContract {
    interface Navigator {
        fun goDetail(id: String)
    }

    interface ViewModel{
        fun addPets(list: List<ItemPet>)
        fun deletePet(id: String)
    }
}