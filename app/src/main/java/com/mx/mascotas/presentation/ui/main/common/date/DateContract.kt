package com.mx.mascotas.presentation.ui.main.vet.date

import com.mx.mascotas.domain.entity.ItemDate

interface DateContract {
    interface Navigator {
    }

    interface ViewModel{
        fun addItems(list: List<ItemDate>)
    }
}