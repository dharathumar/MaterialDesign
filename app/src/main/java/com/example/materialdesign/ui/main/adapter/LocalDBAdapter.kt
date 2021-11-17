package com.example.materialdesign.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesign.R
import com.example.materialdesign.data.entity.Users

class LocalDBAdapter() : RecyclerView.Adapter<LocalDBAdapter.ViewHolder>() {
    private val allUser = ArrayList<Users>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val username = itemView.findViewById<TextView>(R.id.tvName)
        val userNumber = itemView.findViewById<TextView>(R.id.tvphone)
        val userCity = itemView.findViewById<TextView>(R.id.tvcity)
        val userState = itemView.findViewById<TextView>(R.id.tvstate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_localdb,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.username.setText(allUser.get(position).name)
        holder.userNumber.setText(allUser.get(position).number)
        holder.userCity.setText(allUser.get(position).city)
        holder.userState.setText(allUser.get(position).state)

        holder.itemView.setOnClickListener {
        }
    }

    override fun getItemCount(): Int {
        return allUser.size
    }

    fun updateList(newList: List<Users>) {

        allUser.clear()
        allUser.addAll(newList)
        notifyDataSetChanged()
    }

}