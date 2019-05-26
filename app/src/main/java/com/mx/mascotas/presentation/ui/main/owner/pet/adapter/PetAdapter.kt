package com.mx.mascotas.presentation.ui.main.owner.pet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mx.mascotas.domain.entity.ItemPet
import com.mx.mascotas.databinding.ItemPetBinding

class PetAdapter(var list: List<ItemPet>): RecyclerView.Adapter<PetAdapter.ItemPetHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPetHolder {
        val binding = ItemPetBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemPetHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemPetHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ItemPetHolder(val itemPetBinding: ItemPetBinding):RecyclerView.ViewHolder(itemPetBinding.root){
        fun bind(itemPet : ItemPet){
            itemPetBinding.item = itemPet
            itemPetBinding.executePendingBindings()
        }
    }
}