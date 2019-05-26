package com.mx.mascotas.data.repository.datasource.veterinary

import com.google.firebase.database.FirebaseDatabase
import com.mx.mascotas.data.database.entity.Veterinary
import com.mx.mascotas.data.utils.Constants
import com.mx.mascotas.data.utils.RxFirebaseUtils
import io.reactivex.Observable

class VeterinaryDataFirebase(private var firebaseDatabase: FirebaseDatabase) : VeterinaryData<Observable<Boolean>> {
    override fun insert(obj: Veterinary): Observable<Boolean> {
        return RxFirebaseUtils.apply(firebaseDatabase.reference.child(Constants.FireBasePaths.PATH_VET_VET.plus(obj.rfc)).updateChildren(obj.toMap()))

    }

    override fun update(obj: Veterinary): Observable<Boolean> {
        return RxFirebaseUtils.apply(firebaseDatabase.reference.child(Constants.FireBasePaths.PATH_VET_VET.plus(obj.rfc)).updateChildren(obj.toMap()))

    }

    override fun delete(obj: Veterinary): Observable<Boolean> {
        return RxFirebaseUtils.apply(firebaseDatabase.reference.child(Constants.FireBasePaths.PATH_VET_VET.plus(obj.rfc)).removeValue())
    }
}