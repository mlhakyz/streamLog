package com.mlhakyz.streamlog

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mlhakyz.streamlog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var kategoriListe :ArrayList<Kategoriler>
    private lateinit var adapter: KategoriAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarKategori.title = "Kategoriler"
        setSupportActionBar(binding.toolbarKategori)

        binding.kategoriRv.setHasFixedSize(true)
        binding.kategoriRv.layoutManager = LinearLayoutManager(this)

        kategoriListe = ArrayList()

        val k1 = Kategoriler(1,"Bilim Kurgu")
        val k2 = Kategoriler(2,"Komedi")

        kategoriListe.add(k1)
        kategoriListe.add(k2)

        adapter = KategoriAdapter(this, kategoriListe)

        binding.kategoriRv.adapter = adapter
    }


}