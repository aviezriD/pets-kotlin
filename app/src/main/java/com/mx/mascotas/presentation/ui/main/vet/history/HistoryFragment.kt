package com.mx.mascotas.presentation.ui.main.vet.history

import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.domain.usecase.history.HistoryUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment

class HistoryFragment: BaseFragment<com.mx.mascotas.databinding.FragmentHistoryBinding,HistoryViewModel>(),HistoryContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { HistoryViewModel(scheduler,this,HistoryUseCaseImpl())}
    override fun getIdLayout(): Int {
        return R.layout.fragment_history
    }

    override fun getBindingVariable(): Int {
        return BR.historyViewModel
    }

    override fun getViewModel(): HistoryViewModel {
        return viewModelI
    }
}