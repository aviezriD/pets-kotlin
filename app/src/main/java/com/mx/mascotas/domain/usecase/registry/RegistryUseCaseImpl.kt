package com.mx.mascotas.domain.usecase.registry

import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.domain.repository.UserRepository
import io.reactivex.Observable

class RegistryUseCaseImpl(private var userRepository: UserRepository): RegistryUseCase {
    override fun register(user: User): Observable<Boolean> {
        return userRepository.register(user) //register in firebase
    }
}