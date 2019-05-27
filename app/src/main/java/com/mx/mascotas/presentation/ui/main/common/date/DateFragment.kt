package com.mx.mascotas.presentation.ui.main.vet.date

import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.domain.usecase.date.DateUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.databinding.FragmentDateBinding

class DateFragment: BaseFragment<FragmentDateBinding,DateViewModel>(),DateContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { DateViewModel(scheduler,this,DateUseCaseImpl()) }
    override fun getIdLayout(): Int {
        return R.layout.fragment_date
    }

    override fun getBindingVariable(): Int {
        return BR.dateViewModel
    }

    override fun getViewModel(): DateViewModel {
        return viewModelI
    }
}