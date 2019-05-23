package com.mx.mascotas.presentation.ui.utils


import android.util.Log
import com.google.android.material.textfield.TextInputLayout
import androidx.databinding.BindingAdapter
import com.google.android.material.navigation.NavigationView
import com.mx.mascotas.R


@BindingAdapter("errorValidation")
fun setErrorMessage(view: TextInputLayout?, string: String?) {
    Log.i("errorText","msg -> $string")
    view?.let {
        it.error
        string?.let { it2->
            if (!it2.isEmpty())
                it.error = it2
        }
    }

}

@BindingAdapter("validation", "errorMsg")
fun setErrorEnable(textInputLayout: TextInputLayout?, stringRule: StringRule?, errorMsg: String?) {
    textInputLayout?.let {
        it.editText?.let {
            edi ->
            if (stringRule?.validate(edi)== true)
                it.error = errorMsg
        }
    }
}

@BindingAdapter("setMenu")
fun setMenuNavigationView(navigationView: NavigationView?, enable :Boolean?){
    Log.i("setMenu"," $enable")
    navigationView?.let {
        it.menu.clear()
        enable?.let { ena ->
            if (ena)
                it.inflateMenu(R.menu.activity_main_drawer_dueno)
            else
                it.inflateMenu(R.menu.activity_main_drawer_veterinario)
        }
    }

}
