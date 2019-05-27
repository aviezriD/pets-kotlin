package com.mx.mascotas.presentation.ui.main.owner.pet.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mx.mascotas.R
import com.mx.mascotas.domain.entity.ItemPet
import com.mx.mascotas.databinding.ItemPetBinding

class PetAdapter(var list: List<ItemPet>): RecyclerView.Adapter<PetAdapter.ItemPetHolder>() {
    private var listerner :OnclickPetListener? = null
    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnclickInterface( listener : OnclickPetListener){
        this.listerner = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPetHolder {
        val binding = ItemPetBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemPetHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemPetHolder, position: Int) {
        holder.bind(list[position],position)
    }

    inner class ItemPetHolder(val itemPetBinding: ItemPetBinding):RecyclerView.ViewHolder(itemPetBinding.root){
        fun bind(itemPet : ItemPet, position: Int){
            itemPetBinding.item = itemPet
            itemPetBinding.toolCard.setOnMenuItemClickListener { item ->
                Log.i("menu"," $item")
                when(item.itemId){
                    R.id.card_pet_edit -> listerner?.action(list[position].id,1)
                    R.id.card_pet_delete ->listerner?.action(list[position].id,0)
                    else -> Log.i("","")
                }
                true
            }
            itemPetBinding.executePendingBindings()
        }
    }

    interface OnclickPetListener{
        fun action(id: String, operation: Int)

    }
}