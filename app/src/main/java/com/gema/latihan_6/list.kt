package com.gema.latihan_6

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
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


        val nama_hewan = listOf("gajah","beruang","ikan","lumba-lumba","ular","bekicot","sapi","kambing")

        //kita masukan data array hewan ke adapter

        lv_item.adapter = ArrayAdapter(this ,android.R.layout.simple_list_item_1,nama_hewan)
        // listview widget --> adapter --> data source (array list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}