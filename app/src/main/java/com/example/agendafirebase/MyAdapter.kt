package com.example.agendafirebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val agendaList : ArrayList<AgendaActivity>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.agenda_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = agendaList[position]

        holder.name.text = currentitem.name
        holder.email.text = currentitem.email
        holder.phone.text = currentitem.phone
        holder.location.text = currentitem.location
        holder.occupation.text = currentitem.occupation


    }

    override fun getItemCount(): Int {

        return agendaList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val name : TextView = itemView.findViewById(R.id.tvName)
        val email : TextView = itemView.findViewById(R.id.tvEmail)
        val phone : TextView = itemView.findViewById(R.id.tvPhone)
        val location : TextView = itemView.findViewById(R.id.tvLocation)
        val occupation : TextView = itemView.findViewById(R.id.tvOccupation)


    }

}