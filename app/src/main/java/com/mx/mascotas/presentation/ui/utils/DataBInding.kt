package com.mx.mascotas.presentation.ui.utils

import android.util.Log
import com.google.android.material.textfield.TextInputLayout
import androidx.databinding.BindingAdapter


@BindingAdapter("errorValidation")
fun setErrorMessage(view: TextInputLayout?, msg: String?) {
    Log.i("errorText","msg -> $msg")
    view?.let {
        it.error
        msg?.let { it2->
            if (!it2.isEmpty())
                it.error = it2
        }
    }

}