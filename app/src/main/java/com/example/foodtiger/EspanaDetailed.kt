package com.example.foodtiger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.foodtiger.databinding.ActivityEspanaDetailedBinding

class EspanaDetailed : AppCompatActivity() {
    private lateinit var binding: ActivityEspanaDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEspanaDetailedBinding.inflate(layoutInflater)
                setContentView(binding.root)

        val intent = this.intent
        if(intent != null){
            val name = intent.getStringExtra("name")
            val address = intent.getStringExtra("address")
            val operatinghours = intent.getStringExtra("operatinghours")
            val image = intent.getIntExtra("image", R.drawable.tigerwinx)
            val menu = intent.getIntExtra("menu", R.drawable.tigewinxmenu)



           binding.detailName.text = name
            binding.detailAddress.text = address
            binding.detailTime.text = operatinghours
            binding.detailImage.setImageResource(image)
            binding.detailMenu.setImageResource(menu)

            var backBtn = findViewById<ImageButton>(R.id.btn_back2)

            backBtn.setOnClickListener {
                val intent = Intent(this, EspanaMainList::class.java)
                startActivity(intent)
            }




            }
        }
    }
