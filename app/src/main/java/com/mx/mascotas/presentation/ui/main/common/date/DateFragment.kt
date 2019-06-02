package com.mx.mascotas.presentation.ui.main.vet.date

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.repository.DateDataRepository
import com.mx.mascotas.domain.usecase.date.DateUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.databinding.FragmentDateBinding
import com.mx.mascotas.presentation.ui.main.common.detaildate.DetailDateFragment
import com.mx.mascotas.presentation.ui.main.vet.date.adapter.DateAdapter
import kotlinx.android.synthetic.main.fragment_date.*

class DateFragment: BaseFragment<FragmentDateBinding,DateViewModel>(),DateContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { DateViewModel(scheduler,this,DateUseCaseImpl(DateDataRepository(), MascotasAplication.application.appPreferences)) }
    private val adapter by lazy { DateAdapter(emptyList()) }

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
        dateList.adapter = adapter
        adapter.setOnClickListerner(object : DateAdapter.OnClickDate{
                override fun onClick(id: Int) {
                goFragment(R.id.container_main,DetailDateFragment().apply { val args = Bundle()
                    args.putInt("id", id)
                    this.arguments = args })
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subcribeToLiveData()
    }

    fun subcribeToLiveData(){
        viewModelI.list.observe(this, Observer {
            Log.i("date"," $it")
            it?.let {
                viewModelI.addItems(it)
            }
        })
    }
}