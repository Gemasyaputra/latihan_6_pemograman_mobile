package com.gema.latihan_6

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class list : AppCompatActivity() {


    private lateinit var lv_item : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        lv_item = findViewById(R.id.n_hewan)


        val nama_hewan = arrayOf("gajah","beruang","ikan","lumba-lumba","harimau")

        //kita masukan data array hewan ke adapter

        val hewan_desk = arrayOf("gajah adalah hewan yang lucu dan besar.",
            "beruang adalah hewan yang ganas dan pelindung anaknya.",
            "ikan adalah hewan air yang suka berenang.",
            "lumba-lumba adalah hewan yang pintar dan cerdas.",
            "Harimau adalah kucing besar yang buas dan kuat.")

        lv_item.adapter = ArrayAdapter(this ,android.R.layout.simple_list_item_1,nama_hewan)
        // listview widget --> adapter --> data source (array list)

        // agar bisa di click

        lv_item.setOnItemClickListener() {
            parent,view,position , id ->
            Toast.makeText(this,"anda memilih : ${nama_hewan[position]}",
                Toast.LENGTH_SHORT).show()

        val intent = Intent(this@list, DetailHewanActivity::class.java)
            intent.putExtra("desk",hewan_desk[position])
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}