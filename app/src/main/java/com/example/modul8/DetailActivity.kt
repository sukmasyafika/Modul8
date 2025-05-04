package com.example.modul8

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val image = intent.getParcelableExtra<DataModel>(MainActivity.INTENT_PARCELABLE)
        val gambar: ImageView = findViewById(R.id.icons_image)
        val textJudul: TextView = findViewById(R.id.title_image)
        val textDesk: TextView = findViewById(R.id.desk_image)

        gambar.setImageResource(image!!.icons)
        textJudul.text = image.title
        textDesk.text = image.desc
    }
}