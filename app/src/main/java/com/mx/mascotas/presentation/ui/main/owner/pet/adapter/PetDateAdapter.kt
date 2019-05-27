package com.mx.mascotas.presentation.ui.main.owner.pet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mx.mascotas.databinding.ItemDateBinding
import com.mx.mascotas.domain.entity.ItemDate


class PetDateAdapter(var list: List<ItemDate>): RecyclerView.Adapter<PetDateAdapter.ItemDateHolder>(){
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDateHolder {
        val binding = ItemDateBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemDateHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemDateHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ItemDateHolder(val itemDateBinding: ItemDateBinding):RecyclerView.ViewHolder(itemDateBinding.root){
        fun bind(itemDate: ItemDate){
            itemDateBinding.item = itemDate
            itemDateBinding.executePendingBindings()
        }
    }

}