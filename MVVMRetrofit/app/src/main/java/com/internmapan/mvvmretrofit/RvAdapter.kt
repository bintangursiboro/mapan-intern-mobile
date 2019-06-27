package com.internmapan.mvvmretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_list.view.*

class RvAdapter : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    var list = ArrayList<String>()

    fun setData(list: ArrayList<String>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_list,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class  ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(string: String){
            itemView.tview.text = string
        }
    }

}