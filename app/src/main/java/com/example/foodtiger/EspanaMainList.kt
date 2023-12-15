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

class EspanaMainList : AppCompatActivity() {

    private lateinit var binding: ActivityEspanaMainListBinding
    private lateinit var listAdapter: EspanaListAdapter
    private lateinit var listData: EspanaListData
    var dataArrayList = ArrayList<EspanaListData?>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_espana_main_list)
        binding = ActivityEspanaMainListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nameList = arrayOf("Goldilocks", "Jollibee", "KFC", "Mcdonald's", "Shaykey's", "Starbucks", "Yellow Cab")
        val addresslist = arrayOf(
            "873 España Blvd, Sampaloc, Manila, 1015 Metro Manila",
            "Level 1, ONE GRAND CENTRE Espana Blvd, Corner F Jhocson St, Manila City, Metro Manila",
            "Zone 052, 846 Maceda St, Sampaloc, Manila, 1015 Metro Manila",
            "España Blvd, corner Carola, Don Quijote St, Sampaloc, Manila, 1008 Metro Manila",
            "Rodriguez Building, España Blvd, Sampaloc, Manila, 1008 Metro Manila",
            "G/F, One Torre de Santo Tomas, 860 M.F. Jhocson, corner España Blvd, Sampaloc, Manila, 1015 Metro Manila",
            "España Blvd, corner Lacson Ave, Sampaloc, Manila, 1015 Metro Manila"

        )

        val operatinghourslist = arrayOf(
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm"


        )

        val imageList = intArrayOf(
            R.drawable.goldilockslogo,
            R.drawable.jollibee,
            R.drawable.kfclogo,
            R.drawable.mcdologo,
            R.drawable.shaykeyslogo,
            R.drawable.sblogo,
            R.drawable.yellowcablogo,
            )

        val menuList = intArrayOf(
            R.drawable.goldilocksmenu,
            R.drawable.jollibeemenu,
            R.drawable.kfcmenu,
            R.drawable.mcdomenu,
            R.drawable.shaykeysmenu,
            R.drawable.sbmenu,
            R.drawable.yelowmenu
        )

        for (i in imageList.indices){
            listData = EspanaListData(nameList[i], addresslist[i], operatinghourslist[i], menuList[i], imageList[i])
            dataArrayList.add(listData)
        }


        listAdapter = EspanaListAdapter(this@EspanaMainList, dataArrayList)
        binding.espanalistview.adapter = listAdapter
        binding.espanalistview.isClickable = true


        binding.espanalistview.onItemClickListener = AdapterView.OnItemClickListener{ adapterView, view, i, l ->
            val intent = Intent(this@EspanaMainList, EspanaDetailed::class.java)
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