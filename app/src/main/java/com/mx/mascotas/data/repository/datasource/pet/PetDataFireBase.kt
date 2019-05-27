package com.mx.mascotas.data.repository.datasource.pet

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.utils.Constants.FireBasePaths.PATH_PET
import com.mx.mascotas.data.utils.RxFirebaseUtils
import durdinapps.rxfirebase2.RxFirebaseChildEvent
import durdinapps.rxfirebase2.RxFirebaseDatabase
import io.reactivex.Observable

class PetDataFireBase(private var firebaseDatabase: FirebaseDatabase) : PetData<Observable<RxFirebaseChildEvent<DataSnapshot>>,Observable<RxFirebaseChildEvent<DataSnapshot>>,Observable<Boolean>> {
    override fun insert(obj: Pet): Observable<Boolean> {
        val data = PATH_PET.plus(obj.owner)
        return RxFirebaseUtils.observeValueEvent(firebaseDatabase.reference.child(data))
            .flatMap { dataSnapshot ->
                if (dataSnapshot.exists()) {
                    Observable.just(false)
                } else {
                    RxFirebaseUtils.apply(firebaseDatabase.reference.child(data).updateChildren(obj.toMap()))
                }
            }
            .map { true }
    }

    override fun update(obj: Pet): Observable<Boolean> {
        val data = PATH_PET.plus(obj.owner)
        return RxFirebaseUtils.observeValueEvent(firebaseDatabase.reference.child(data))
            .flatMap { dataSnapshot ->
                RxFirebaseUtils.apply(firebaseDatabase.reference.child(data).updateChildren(obj.toMap()))
            }
    }

    override fun delete(obj: Pet): Observable<Boolean> {
        val data = PATH_PET.plus(obj.owner)
        return RxFirebaseUtils.apply(firebaseDatabase.reference.child(data).removeValue())
    }

    override fun getListPetByName(user: String): Observable<RxFirebaseChildEvent<DataSnapshot>> {
        val data = PATH_PET.plus(user)
        return RxFirebaseDatabase.observeChildEvent(firebaseDatabase.reference.child(data))
            .toObservable()
    }

    override fun getPetById(id: String): Observable<RxFirebaseChildEvent<DataSnapshot>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}