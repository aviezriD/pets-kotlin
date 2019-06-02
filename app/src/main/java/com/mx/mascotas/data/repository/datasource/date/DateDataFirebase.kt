package com.mx.mascotas.data.repository.datasource.date

import androidx.lifecycle.LiveData
import com.google.firebase.database.FirebaseDatabase
import com.mx.mascotas.data.utils.Constants
import com.mx.mascotas.data.utils.RxFirebaseUtils
import io.reactivex.Observable
import java.util.*

class DateDataFirebase (private var firebaseDatabase: FirebaseDatabase): DateData<Date,Observable<Boolean>> {
    override fun insert(obj: com.mx.mascotas.data.database.entity.Date): Observable<Boolean> {
       var data = if (obj.idRol == 0){
           Constants.FireBasePaths.PATH_OWNER_DATE
       }
        else
       {
           Constants.FireBasePaths.PATH_VET_DATE
       }
        return RxFirebaseUtils.observeValueEvent(firebaseDatabase.reference.child(data.plus(obj.id)))
            .flatMap { programmingdate ->
                if (programmingdate.exists()) {
                    Observable.just(false)
                } else {
                    RxFirebaseUtils.apply(firebaseDatabase.reference.child(data).updateChildren(obj.toMap()))

                }

            }
    }

    override fun update(obj: com.mx.mascotas.data.database.entity.Date): Observable<Boolean> {
        var data = if (obj.idRol == 0){
            Constants.FireBasePaths.PATH_OWNER_DATE
        }
        else
        {
            Constants.FireBasePaths.PATH_VET_DATE
        }
        return RxFirebaseUtils.observeValueEvent(firebaseDatabase.reference.child(data.plus(obj.id)))
            .flatMap {
                RxFirebaseUtils.apply(firebaseDatabase.reference.child(data).updateChildren(obj.toMap()))
            }
    }

    override fun delete(obj: com.mx.mascotas.data.database.entity.Date): Observable<Boolean> {
        var data = if (obj.idRol == 0){
            Constants.FireBasePaths.PATH_OWNER_DATE

        }
        else
        {
            Constants.FireBasePaths.PATH_VET_DATE
        }
        return RxFirebaseUtils.apply(firebaseDatabase.reference.child(data.plus(obj.id)).removeValue())

    }

    override fun getListDatePending(id: String): Date {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListDateByIdUser(id: String): Date {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDateById(id: Int): LiveData<com.mx.mascotas.data.database.entity.Date> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}