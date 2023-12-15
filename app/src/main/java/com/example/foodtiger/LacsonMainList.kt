package com.example.foodtiger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ListView
import androidx.recyclerview.widget.ListAdapter
import com.example.foodtiger.databinding.ActivityEspanaMainListBinding
import com.example.foodtiger.databinding.ActivityLacsonMainListBinding

class LacsonMainList : AppCompatActivity() {

    private lateinit var binding: ActivityLacsonMainListBinding
    private lateinit var listAdapter: LacsonListAdapter
    private lateinit var listData: LacsonListData
    var dataArrayList = ArrayList<LacsonListData?>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lacson_main_list)
        binding = ActivityLacsonMainListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nameList = arrayOf("Big Guys Pizza", "Jollibee", "Kafe Lounge", "Mcdonald's", "Yellow Cab")
        val addresslist = arrayOf(
            "910 Lacson Ave, Sampaloc, Manila, 1008 Metro Manila",
            "1523 Dapitan St, Sampaloc, Manila, 1015 Metro Manila",
            "Stall 09, Grand Residences España 2, Lacson Ave, Sampaloc, Manila, 1008 Metro Manila",
            "Governor Forbes, Sampaloc, Manila, 1800 Metro Manila",
            "Governor Forbes, 1122 Lourdes bldg, Lacson Ave, Sampaloc, Manila, 1008 Metro Manila"

        )

        val operatinghourslist = arrayOf(
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm"

        )

        val imageList = intArrayOf(
            R.drawable.bigguys,
            R.drawable.jollibee,
            R.drawable.kafe,
            R.drawable.mcdologo,
            R.drawable.yellowcablogo,
            )

        val menuList = intArrayOf(
            R.drawable.bigguysmenu,
            R.drawable.jollibeemenu,
            R.drawable.kafemenu,
            R.drawable.mcdomenu,
            R.drawable.yelowmenu
        )

        for (i in imageList.indices){
            listData = LacsonListData(nameList[i], addresslist[i], operatinghourslist[i], menuList[i], imageList[i])
            dataArrayList.add(listData)
        }


        listAdapter = LacsonListAdapter(this@LacsonMainList, dataArrayList)
        binding.lacsonlistview.adapter = listAdapter
        binding.lacsonlistview.isClickable = true


        binding.lacsonlistview.onItemClickListener = AdapterView.OnItemClickListener{ adapterView, view, i, l ->
            val intent = Intent(this@LacsonMainList, LacsonDetailed::class.java)
            intent.putExtra("name", nameList[i])
            intent.putExtra("address", addresslist[i])
            intent.putExtra("operatinghours", operatinghourslist[i])
            intent.putExtra("image", imageList[i])
            intent.putExtra("menu", menuList[i])
            startActivity(intent)


            var backBtn1 = findViewById<ImageButton>(R.id.btn_back1)

            backBtn1.setOnClickListener {
                val intent = Intent(this, Categories::class.java)
                startActivity(intent)
            }
        }
    }
}