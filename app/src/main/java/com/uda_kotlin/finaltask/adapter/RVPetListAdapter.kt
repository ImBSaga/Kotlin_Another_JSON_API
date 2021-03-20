package com.uda_kotlin.finaltask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uda_kotlin.finaltask.R
import com.uda_kotlin.finaltask.model.getdata.DataItem
import kotlinx.android.synthetic.main.item_pet.view.*

class RVPetListAdapter(val data: List<DataItem>?, val itemClick: OnClickListener) :
    RecyclerView.Adapter<RVPetListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = data?.get(position)

        holder.tv_name.text = data?.get(position)?.nama
        holder.tv_category.text = data?.get(position)?.category
        Glide.with(holder.itemView.context).load(data?.get(position)?.photo).into(holder.iv_photo)

        holder.itemView.setOnClickListener {
            itemClick.detail(item)
        }

        holder.itemView.setOnClickListener {
            itemClick.hapus(item)
        }

    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //Add Kotlin Extension
        val tv_name = view.tv_pet_name
        val tv_category = view.tv_pet_category
        val iv_photo = view.iv_pet_photo
        val btn_hapus = view.btn_hapus
    }

    interface OnClickListener {
        fun detail(item: DataItem?)
        fun hapus(item: DataItem?)
    }
}