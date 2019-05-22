package com.mx.mascotas.presentation.ui.utils

import android.text.TextUtils
import android.widget.EditText

val NOT_EMPTY_RULE  = object : StringRule {
    override fun validate(textInputEditText: EditText):Boolean {
        return TextUtils.isEmpty(textInputEditText.text.toString())
    }
}
//var NOT_EMPTY_RULE : StringRule= { s -> TextUtils.isEmpty(s.toString()) }