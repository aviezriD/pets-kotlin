package com.mx.mascotas.presentation.ui.utils

import android.app.DatePickerDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Environment
import android.widget.DatePicker
import com.google.android.material.textfield.TextInputEditText
import com.mx.mascotas.MascotasAplication
import java.io.File
import java.io.IOException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun isOnline() : Boolean{
        val cm = MascotasAplication.application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    fun getFecha(datePicker: DatePicker): String {
        val cal = Calendar.getInstance()
        cal.set(
            datePicker.year,
            datePicker.month,
            datePicker.dayOfMonth
        )
        val formatoFecha = "dd/MM/yyyy"
        val df = SimpleDateFormat(formatoFecha)
        return df.format(cal.time)
    }


    private val ID_ZONA_HORARIA = "America/Mexico_City"
    private val FORMAT_DATE = "dd/MM/yyyy"

    private val formats = arrayOf("dd-MM-yyyy", "dd/MM/yyyy", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss")

    fun converStringToDate(fecha: String): Date? {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        try {
            return formatter.parse(fecha)
        } catch (e1: ParseException) {
            e1.printStackTrace()
            return null
        }

    }

    fun longToDate(date: Long): String {
        val temp = Calendar.getInstance()
            temp.timeInMillis = date
        return converDateToString(temp.time)
    }

    fun converDateToString(date: Date): String {
        val fomater = SimpleDateFormat(formats[1], Locale.getDefault())
        return fomater.format(date)
    }

    fun stringToDate(fecha: String): Date? {
        val formatter = SimpleDateFormat(FORMAT_DATE)
        try {
            return formatter.parse(fecha)
        } catch (e1: ParseException) {
            e1.printStackTrace()
            return null
        }

    }

    fun longToHour(date: Long):String{
        val temp = Calendar.getInstance()
        temp.timeInMillis = date
        return dateTimeToHour(temp.time)
    }

    fun dateTimeToHour(date: Date): String {
        if (date != null) {
            val format = SimpleDateFormat("HH:mm:ss")
            return format.format(date)
        } else {
            return ""
        }
    }


    fun generaDatePickerDialog(textInputEditText: TextInputEditText, enable: Boolean, context: Context) {
        val fechaActual = Calendar.getInstance()
        val date = textInputEditText.getEditableText().toString().trim()
        var anio = fechaActual.get(Calendar.YEAR)
        var mes = fechaActual.get(Calendar.MONTH)
        var dia = fechaActual.get(Calendar.DAY_OF_MONTH)

        if (!date.isEmpty()) {
            val fecha = Utils.stringToDate(date)
            if (fecha != null) {
                fechaActual.time = fecha
                anio = fechaActual.get(Calendar.YEAR)
                mes = fechaActual.get(Calendar.MONTH)
                dia = fechaActual.get(Calendar.DAY_OF_MONTH)
            }
        }
        if (!enable) {
            dia = fechaActual.get(Calendar.DAY_OF_MONTH) + 1
        }
        val datePickerDialog = DatePickerDialog(
            context,
            { view, year, month, dayOfMonth -> textInputEditText.setText(getFecha(view)) },
            anio,
            mes,
            dia
        )
        if (enable) {
            datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
        } else {
            datePickerDialog.datePicker.minDate = System.currentTimeMillis()
        }

        datePickerDialog.show()
    }

    @Throws(IOException::class)
    fun createImageFile(): File {
        val imageFileName = "JPEG_" + "photo" + "_"
        val storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        //        Log.d("ruta-1",storageDir.getAbsolutePath());
        val image = File.createTempFile(
            imageFileName, /* prefix */
            ".jpg", /* suffix */
            storageDir      /* directory */
        )
        // Save a file: path for use with ACTION_VIEW intents
        return image
    }

}