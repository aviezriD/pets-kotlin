package com.mx.mascotas.presentation.ui.main.common.detaildate

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.repository.DateDataRepository
import com.mx.mascotas.domain.usecase.detaildate.DetailDateUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.presentation.ui.utils.Utils
import kotlinx.android.synthetic.main.fragment_detail_date.*
import kotlinx.android.synthetic.main.fragment_pet.*
import java.util.*

class DetailDateFragment : BaseFragment<com.mx.mascotas.databinding.FragmentDetailDateBinding,DetailDateViewModel>(),DetailDateContract.Navigator{
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { DetailDateViewModel(scheduler,this,DetailDateUseCaseImpl(DateDataRepository()))}
    private var idDate = -1

    override fun getIdLayout(): Int {
        return R.layout.fragment_detail_date
    }

    override fun getBindingVariable(): Int {
        return BR.detailDateViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idDate = it.getInt("id",-1)
        }
        viewModelI.date.observe(this, Observer {
            it?.let {
                viewModelI.setData(it)
            }
        })
        viewModelI.id.value= idDate
    }

    override fun getViewModel(): DetailDateViewModel {
        return viewModelI
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        date_next.setOnTouchListener { v, event ->
            if (v.id == date_next.id && event.action == 0 )
                Utils.generaDatePickerDialog(date_next, false, view.context)
            true
        }

        hour_next.setOnTouchListener{ v, event ->
            if (v.id == hour_next.id && event.action == 0 ){
                val mcurrentTime = Calendar.getInstance()
                val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
                val minute = mcurrentTime.get(Calendar.MINUTE)
                val mTimePicker: TimePickerDialog
                mTimePicker = TimePickerDialog(activity,
                    TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                        if (selectedMinute == 0 || selectedMinute == 30) {
                            if (selectedMinute == 0) {
                                hour_next.setText(selectedHour.toString() + ":" + selectedMinute + "0")
//                            sHour = selectedHour.toString() + ":" + selectedMinute + "0"
                            } else {
                                hour_next.setText("$selectedHour:$selectedMinute")
//                            sHour = "$selectedHour:$selectedMinute"
                            }
                        }
                    }, hour, minute, true
                )//Yes 24 hour time

                mTimePicker.setCancelable(false)
                mTimePicker.setTitle("Select Time")
                mTimePicker.show()
            }

            true
        }
    }
}