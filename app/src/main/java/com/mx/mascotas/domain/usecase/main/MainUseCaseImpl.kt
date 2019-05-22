package com.mx.mascotas.domain.usecase.main

import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.domain.repository.PreferenceRepository
import com.mx.mascotas.domain.repository.UserRepository
import io.reactivex.Observable

class MainUseCaseImpl(private var userRepository: UserRepository, private val preference: PreferenceRepository): MainUseCase {
    override fun getUser(): Observable<User> {
        return userRepository.login(preference.getUserName(),preference.getRole(),false)
    }
}