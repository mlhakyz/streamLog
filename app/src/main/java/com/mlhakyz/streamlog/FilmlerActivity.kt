package com.mlhakyz.streamlog

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mlhakyz.streamlog.databinding.ActivityFilmlerBinding
import com.mlhakyz.streamlog.databinding.ActivityMainBinding

class FilmlerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilmlerBinding

    private lateinit var filmListe :ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFilmlerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler


        binding.toolbarFilmler.title = "Filmler: ${kategori.kategori_ad}"
        setSupportActionBar(binding.toolbarFilmler)

        binding.filmlerRv.setHasFixedSize(true)
        binding.filmlerRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        filmListe = ArrayList()

        val k = Kategoriler(1,"Bilim Kurgu")
        val y = Yonetmenler(1 , "Peter Jackson")

        val f1 = Filmler(1,"Interstaller",2004,"interstellar",k,y)

        val f2 = Filmler(1,"Django",2006,"django",k,y)
        val f3 = Filmler(1,"Inception",2014,"inception",k,y)

        filmListe.add(f1)
        filmListe.add(f2)
        filmListe.add(f3)

        adapter = FilmlerAdapter(this,filmListe)
        binding.filmlerRv.adapter = adapter

    }
}