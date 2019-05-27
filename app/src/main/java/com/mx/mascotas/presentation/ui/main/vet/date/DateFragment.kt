package com.mx.mascotas.presentation.ui.main.vet.date

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.domain.usecase.date.DateUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.databinding.FragmentDateBinding
import kotlinx.android.synthetic.main.fragment_date.*

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dateList.layoutManager = LinearLayoutManager(context)
        dateList.itemAnimator = DefaultItemAnimator()
        dateList.setHasFixedSize(true)
        dateList
        dateList
    }
}