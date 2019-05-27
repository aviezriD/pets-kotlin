package com.mx.mascotas.presentation.ui.main.common.detaildate

import com.mx.mascotas.data.database.entity.Date

interface DetailDateContract {
    interface Navigator {
    }

    interface ViewModel{
        fun setData(date : Date)
    }
}