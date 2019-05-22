package com.mx.mascotas.data.utils

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import durdinapps.rxfirebase2.exceptions.RxFirebaseDataException
import io.reactivex.Observable

class RxFirebaseUtils {

    companion object {
        fun observeSingleValueEvent(query: Query): Observable<DataSnapshot> {
            return Observable.create { emitter ->
                query.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        emitter.onNext(dataSnapshot)
                    }
                    override fun onCancelled(error: DatabaseError) {
                        if (!emitter.isDisposed) {
                            emitter.onError(RxFirebaseDataException(error))
                        }

                    }
                })
            }
        }

        fun observeValueEvent(query: Query): Observable<DataSnapshot> {
            return Observable.create { emitter ->
                query.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        emitter.onNext(dataSnapshot)
                        emitter.onComplete()
                    }
                    override fun onCancelled(error: DatabaseError) {
                        if (!emitter.isDisposed) {
                            Log.e("RxUtils","${error.details}")
                            emitter.onError(RxFirebaseDataException(error))
                        }

                    }
                })
            }
        }

        fun observerChangedValue(query: Query): Observable<DataSnapshot> {
            return Observable.create { emitter ->
                query.addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        Log.e("sync","error $p0")
                        emitter.onError(p0.toException())
                    }

                    override fun onDataChange(p0: DataSnapshot) {
                        emitter.onNext(p0)
                        Log.i("sync","$p0")
                    }
                })
            }
        }

        fun apply(task: Task<Void>): Observable<Boolean> {
            return Observable.create { emitter ->
                task.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        emitter.onNext(true)
                        emitter.onComplete()
                    } else {
                        emitter.onComplete()
                    }
                }
            }
        }
    }
}