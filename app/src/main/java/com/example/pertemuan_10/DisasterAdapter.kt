package com.example.pertemuan_10

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pertemuan_10.databinding.ActivityMainBinding
import com.example.pertemuan_10.databinding.ItemDisasterBinding
import java.lang.System.load

class DisasterAdapter(private val listDisaster: List<Disaster>
    ,private val onClickDisaster: OnClickDisaster) :
    RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder>()
    {
        inner class ItemDisasterViewHolder(
            private val binding: ItemDisasterBinding
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(data: Disaster) {

                Glide.with(binding.root.context)
                    .load(data.imageURL)
                    .fitCenter()
                    .into(binding.gambarUrl)

                with(binding) {
//                    gambarUrl.setImageResource(data.imageURL)
                    namaMobilTxt.text = data.namaMobil
                    hargaMobilTxt.text = data.hargaMobil
                    itemView.setOnClickListener {
                        onClickDisaster(data)
                    }
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
            val binding =
                ItemDisasterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemDisasterViewHolder(binding)
        }
        override fun getItemCount(): Int = listDisaster.size
        override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
            holder.bind(listDisaster[position])
        }
    }


typealias OnClickDisaster = (Disaster) -> Unit