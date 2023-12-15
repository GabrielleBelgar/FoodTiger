package com.example.foodtiger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Categories : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        var dapitanbtn = findViewById<Button>(R.id.categ_dapitan)
        var espanabtn = findViewById<Button>(R.id.categ_espana)
        var lacsonbtn = findViewById<Button>(R.id.categ_lacson)
        var pnovalbtn = findViewById<Button>(R.id.categ_pnoval)

        dapitanbtn.setOnClickListener {
            val intent = Intent(this, DapitanMainList::class.java)
            startActivity(intent)
        }

        espanabtn.setOnClickListener {
            val intent = Intent(this, EspanaMainList::class.java)
            startActivity(intent)
        }

        lacsonbtn.setOnClickListener {
            val intent = Intent(this, LacsonMainList::class.java)
            startActivity(intent)
        }

        pnovalbtn.setOnClickListener {
            val intent = Intent(this, PNovalMainList::class.java)
            startActivity(intent)
        }
    }
    }