package com.example.modul8

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private var gridLayoutManager : GridLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageList = listOf<DataModel>(
            DataModel(
                R.drawable.boruto,
                "Boruto Uzumaki",
                """
                ✨ Nama Lengkap: Boruto Uzumaki
                🎂 Tanggal Lahir: 27 Maret
                🧒 Umur: 12 tahun (Boruto: Naruto Next Generations)
                👨‍👩‍👧‍👦 Anak dari Naruto Uzumaki dan Hinata Hyuga
                🏫 Akademi Ninja: Lulus dengan nilai tinggi
                💥 Jurus Unggulan: Rasengan, Shadow Clone Jutsu, Jougan (mata misterius)
                💬 Fakta Unik: Boruto awalnya tidak menyukai ayahnya karena terlalu sibuk sebagai Hokage.
                """.trimIndent()
            ),
            DataModel(
                R.drawable.sarada,
                "Sarada Uchiha",
                """
                ✨ Nama Lengkap: Sarada Uchiha
                🎂 Tanggal Lahir: 31 Maret
                🧒 Umur: 12 tahun
                👨‍👩‍👧‍👦 Anak dari Sasuke Uchiha dan Sakura Haruno
                🏫 Akademi Ninja: Murid pintar dan calon Hokage
                👁️ Jurus Unggulan: Sharingan, Chidori, Shuriken Jutsu
                💬 Fakta Unik: Sarada sangat mengagumi Naruto dan ingin menjadi Hokage.
                """.trimIndent()
            ),
            DataModel(
                R.drawable.himawari,
                "Himawari Uzumaki",
                """
                ✨ Nama Lengkap: Himawari Uzumaki
                🎂 Tanggal Lahir: 25 Agustus
                🧒 Umur: Sekitar 10 tahun
                👨‍👩‍👧‍👦 Anak dari Naruto Uzumaki dan Hinata Hyuga
                👁️ Kemampuan Khusus: Byakugan (seperti keluarga Hyuga)
                🧸 Kepribadian: Lembut, penyayang, dan penuh perhatian
                💬 Fakta Unik: Meskipun belum menjadi ninja, dia pernah membuat Naruto pingsan hanya dengan satu pukulan!
                """.trimIndent()
            ),
            DataModel(
                R.drawable.choco,
                "Choco Akimichi ",
                """
                ✨ Nama Lengkap: Choco Uzumaki
                🎂 Tanggal Lahir: 20 Oktober
                🧒 Umur: 11 tahun
                👨‍👩‍👧‍👦 Karakter fiktif dari fanmade universe
                💥 Jurus Unggulan: Lightning Style dan Clone Jutsu
                🎨 Hobi: Menggambar dan berlatih taijutsu
                💬 Fakta Unik: Memiliki energi besar dan semangat belajar tinggi.
                """.trimIndent()
            ),
            DataModel(
                R.drawable.mitsuki,
                "Mitsuki",
                """
                ✨ Nama Lengkap: Mitsuki
                🎂 Tanggal Lahir: Tidak diketahui secara pasti
                🧒 Umur: Sekitar 12 tahun
                👨‍👩‍👦 Anak hasil eksperimen Orochimaru
                🐍 Kemampuan Khusus: Mode Sage, kemampuan memanjangkan tubuh seperti ular
                💬 Fakta Unik: Meskipun diciptakan secara artifisial, dia memiliki rasa ingin tahu dan kehendak bebas yang kuat.
                """.trimIndent()
            )
        )


        val recyclerView = findViewById<RecyclerView>(R.id.tbvRV)
        gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, imageList) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}