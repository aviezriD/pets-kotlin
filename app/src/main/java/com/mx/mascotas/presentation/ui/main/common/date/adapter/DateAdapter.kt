package com.mx.mascotas.presentation.ui.main.vet.date.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mx.mascotas.domain.entity.ItemDate
import com.mx.mascotas.databinding.ItemDateBinding

class DateAdapter (var list: List<ItemDate>): RecyclerView.Adapter<DateAdapter.ItemDateHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDateHolder {
        val item = ItemDateBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemDateHolder(item)
    }

    override fun onBindViewHolder(holder: ItemDateHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class ItemDateHolder(var itemDate: ItemDateBinding):RecyclerView.ViewHolder(itemDate.root){
        private val adapter = ServiceAdapter(emptyList())
        init {
            itemDate.recyclerView.layoutManager = LinearLayoutManager(itemDate.root.context)
            itemDate.recyclerView.itemAnimator = DefaultItemAnimator()
            itemDate.recyclerView.setHasFixedSize(true)
            itemDate.recyclerView.adapter = adapter
        }

        fun bind(item: ItemDate){
            itemDate.item = item
            itemDate.executePendingBindings()
        }
    }
}