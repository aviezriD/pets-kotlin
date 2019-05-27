package com.mx.mascotas.presentation.ui.main.vet.date.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mx.mascotas.databinding.ItemServiceBinding

class ServiceAdapter(var list: List<String>):  RecyclerView.Adapter<ServiceAdapter.ItemServiceHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemServiceHolder {
        val itemS = ItemServiceBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemServiceHolder(itemS)
    }

    override fun onBindViewHolder(holder: ItemServiceHolder, position: Int) {
        holder.bind(list[position])
    }

    fun add(eltos : List< String>){
        list = eltos
        notifyDataSetChanged()
    }

    inner class ItemServiceHolder(var itemS : ItemServiceBinding):RecyclerView.ViewHolder(itemS.root){
        fun bind (item : String){
            itemS.nameService.text = item
        }

    }
}