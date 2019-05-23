package com.mx.mascotas.presentation.ui.main.common.tip

import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.domain.usecase.tip.TipUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment

class TipFragment : BaseFragment<com.mx.mascotas.databinding.FragmentTipBinding,TipViewModel>(),TipContract.Navigator{
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy {TipViewModel(scheduler,this,TipUseCaseImpl())}

    override fun getIdLayout(): Int {
        return R.layout.fragment_tip
    }

    override fun getBindingVariable(): Int {
        return BR.tipViewModel
    }

    override fun getViewModel(): TipViewModel {
        return viewModelI
    }
}