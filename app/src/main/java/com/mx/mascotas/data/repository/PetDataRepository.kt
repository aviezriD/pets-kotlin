package com.mx.mascotas.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.mx.mascotas.data.database.entity.CatPet
import com.mx.mascotas.data.database.entity.CatPetSize
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.repository.datasource.catpet.CatPetDataFactory
import com.mx.mascotas.data.repository.datasource.catpetsize.CatPetSizeDataFactory
import com.mx.mascotas.data.repository.datasource.pet.PetDataFactory
import com.mx.mascotas.domain.entity.ItemPet
import com.mx.mascotas.domain.repository.PetRepository
import io.reactivex.Observable
import java.util.ArrayList

class PetDataRepository: PetRepository {
    private val petDataFactory by lazy { PetDataFactory() }
    private val petDb by lazy { petDataFactory.createPetDataDb() }
    private val petDataFirebase by lazy { petDataFactory.createPetDataFireBase() }

    private val catPetFactory by lazy { CatPetDataFactory() }
    private val catPetDb by lazy { catPetFactory.createCatPetDataDb()}

    private val catPetSizeFactory by lazy { CatPetSizeDataFactory() }
    private val catSizePetDb by lazy { catPetSizeFactory.createCatPetSizeDataDb()}


    override fun register(pet: Pet): Observable<Boolean> {
        return petDataFirebase.insert(pet)
    }

    override fun insert(pet: Pet) {
        petDb.insert(pet)
    }

    override fun getTypePet(): LiveData<List<CatPet>> {
        return catPetDb.getListCat()
    }

    override fun getListPetByName(user: String): LiveData<List<Pet>> {
        return petDb.getListPetByName(user)
    }

    override fun getListCatPetSize(): LiveData<List<CatPetSize>> {
        return catSizePetDb.getListCatPetSize()
    }
    private fun getNameByType(type : Int): String{
        return when(type){
            0 ->"Perro"
            1 ->"Gato"
            else -> "Otro"
        }
    }
    override fun getListPetByNameMinimal(user: String): LiveData<List<ItemPet>> {
        return Transformations.map(petDb.getListPetByName(user)) { l ->
            val result = ArrayList<ItemPet>()
            for ( i in l)
                result.add(ItemPet(i.id,i.name,i.photo,getNameByType(i.type),i.race))
            result
        }
    }

    override fun deletePet(pet: Pet) {
        petDb.delete(pet)
    }

    override fun getPetById(id: String): LiveData<Pet> {
        return petDb.getPetById(id)
    }
}