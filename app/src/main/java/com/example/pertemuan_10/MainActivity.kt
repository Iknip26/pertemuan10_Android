package com.example.pertemuan_10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.pertemuan_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var deskripsi: Array<String>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        deskripsi = resources.getStringArray(R.array.list_deskripsi)

        val adapterDisaster = DisasterAdapter(generateDummy(deskripsi)) { disaster ->
            val intentoDeskripsi = Intent(this@MainActivity, detailPage::class.java)
            intentoDeskripsi.putExtra("IMAGE_URL", disaster.imageURL)
            intentoDeskripsi.putExtra("NAMA_MOBIL", disaster.namaMobil)
            intentoDeskripsi.putExtra("HARGA_MOBIL", disaster.hargaMobil)
            intentoDeskripsi.putExtra("DESKRIPSI_MOBIL", disaster.deskripsi_mobil)
            startActivity(intentoDeskripsi)
        }

        with(binding){
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }
}

    fun generateDummy(deskripsi: Array<String>): List<Disaster> {

        return listOf(
            Disaster(imageURL = "https://hips.hearstapps.com/hmg-prod/images/2022-lamborghini-aventador-109-1625607587.jpg", namaMobil = "Lamborghini Aventador", hargaMobil = "$ 800", deskripsi_mobil = deskripsi[0]),
            Disaster(imageURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/LaFerrari_in_Beverly_Hills_%2814563979888%29.jpg/1200px-LaFerrari_in_Beverly_Hills_%2814563979888%29.jpg", namaMobil = "Ferrari la Ferrari", hargaMobil = "$ 22,7 M", deskripsi_mobil =deskripsi[1]),
            Disaster(imageURL = "https://images.autofun.co.id/file1/6f200e00ec294e308ccb2708f1aa38c9_1125x630.jpg", namaMobil = "Toyota Supra", hargaMobil = "$ 2,2 M", deskripsi_mobil = deskripsi[2] ),
            Disaster(imageURL = "https://www.topgear.com/sites/default/files/2021/08/2010-Pagani-Zonda-R-Evolution-_74.jpg", namaMobil = "Pagani Zonda", hargaMobil = "$ 17 M", deskripsi_mobil = deskripsi[3]),
            Disaster(imageURL = "https://upload.wikimedia.org/wikipedia/commons/5/53/Veyron_SS.jpg", namaMobil = "Bugatti Feyron", hargaMobil = "$ 1,7 M", deskripsi_mobil = deskripsi[4]),
            Disaster(imageURL = "https://cars.usnews.com/static/images/Auto/izmo/i159614039/2021_porsche_911_0_angularfront.jpg", namaMobil = "Porsche 911", hargaMobil = "$132", deskripsi_mobil = deskripsi[5] )

//            Disaster(imageURL = R.drawable.ic_launcher_background, namaMobil = "Lamborghini Aventador", hargaMobil = "$ 7,2 M"),
//            Disaster(imageURL = R.drawable.ic_launcher_background, namaMobil = "Ferrari la ferrari", hargaMobil = "$ 22,7 M"),
//            Disaster(imageURL = R.drawable.ic_launcher_background, namaMobil = "Toyota Supra", hargaMobil = "$ 2,1 M"),
//            Disaster(imageURL = R.drawable.ic_launcher_background, namaMobil = "Pagani huayra", hargaMobil = "$ 17 M"),
//            Disaster(imageURL = R.drawable.ic_launcher_background, namaMobil = "Bugatti feyron", hargaMobil = "$ 1,7 M"),
//            Disaster(imageURL = R.drawable.ic_launcher_background, namaMobil = "Porsche 911", hargaMobil = "$132")
        )
    }