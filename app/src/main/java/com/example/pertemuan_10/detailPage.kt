package com.example.pertemuan_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.pertemuan_10.databinding.ActivityDetailPageBinding
import com.example.pertemuan_10.databinding.ActivityMainBinding

class detailPage : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        var image_url = intent.getIntExtra("IMAGE_URL", 0)
        var image_url = intent.getStringExtra("IMAGE_URL")
        var nama_mobil = intent.getStringExtra("NAMA_MOBIL")
        var harga_mobil = intent.getStringExtra("HARGA_MOBIL")
        var deskripsi_mobil = intent.getStringExtra("DESKRIPSI_MOBIL")

        with(binding){
            namaMobil.text = nama_mobil
            hargaMobil.text = "Harga : $harga_mobil"
            deskripsiMobil.text = deskripsi_mobil
            Glide.with(this@detailPage)
                .load(image_url)
                .fitCenter()
                .into(binding.gambarDetail)
        }
    }
}