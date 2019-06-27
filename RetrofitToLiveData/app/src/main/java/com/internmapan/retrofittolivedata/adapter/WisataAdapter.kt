package com.internmapan.retrofittolivedata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.internmapan.retrofittolivedata.R
import com.internmapan.retrofittolivedata.model.Wisata
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.wisata_cardview.view.*

class WisataAdapter : RecyclerView.Adapter<WisataAdapter.ViewHolder>() {
    private var list = ArrayList<Wisata>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(wisata: Wisata) {
            itemView.tv_nama_tempat.text = wisata.nama_tempat
            itemView.tv_deskripsi.text = wisata.deskripsi
            itemView.tv_lokasi.text = wisata.lokasi
            Picasso.get().load(wisata.gambar).into(itemView.image_gambar)
        }
    }

    fun setData(list : ArrayList<Wisata>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.wisata_cardview,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WisataAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}