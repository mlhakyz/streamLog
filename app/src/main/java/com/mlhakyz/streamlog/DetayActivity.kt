package com.mlhakyz.streamlog

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mlhakyz.streamlog.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val film = intent.getSerializableExtra("filmNesne") as Filmler

        binding.textViewDetayFilmAd.text = film.film_ad
        binding.textViewFilmYil.text = (film.film_yil).toString()
        binding.textViewYonetmen.text = film.yonetmen.yonetmen_ad



        binding.imageViewResim.setImageResource(this.resources.getIdentifier(film.film_resim,
            "drawable",this.packageName))

    }
}