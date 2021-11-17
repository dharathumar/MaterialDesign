package com.example.materialdesign.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesign.R
import com.example.materialdesign.data.model.Entry
import com.example.materialdesign.data.model.public

class ApiAdapter (private val publivItemList: public) : RecyclerView.Adapter<ApiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.api_layout,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {

        return publivItemList.entries.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${publivItemList.entries.size} ")
        return holder.bind(publivItemList.entries[position])
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var tvApi = itemView.findViewById<TextView>(R.id.tvApi)
        var tvAuth = itemView.findViewById<TextView>(R.id.tvAuth)
        var tvCategory = itemView.findViewById<TextView>(R.id.tvCategory)
        var tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        var tvLink = itemView.findViewById<TextView>(R.id.tvLink)
        fun bind(publicItem: Entry) {
            //  val0 entries: List<Entry>
            tvApi.text = publicItem.API
            tvAuth.text = publicItem.Auth
            tvCategory.text = publicItem.Category
            tvDescription.text = publicItem.Description
            tvLink.text = publicItem.Link
        }
    }
}