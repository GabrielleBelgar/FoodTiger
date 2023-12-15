package com.example.foodtiger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.foodtiger.databinding.ActivityEspanaDetailedBinding
import com.example.foodtiger.databinding.ActivityLacsonDetailedBinding

class LacsonDetailed : AppCompatActivity() {
    private lateinit var binding: ActivityLacsonDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLacsonDetailedBinding.inflate(layoutInflater)
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
                val intent = Intent(this, LacsonMainList::class.java)
                startActivity(intent)
            }




            }
        }
    }
