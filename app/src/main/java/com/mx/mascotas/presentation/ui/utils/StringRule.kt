package com.mx.mascotas.presentation.ui.utils

import android.widget.EditText

interface StringRule {
    fun validate(editText : EditText): Boolean
}
