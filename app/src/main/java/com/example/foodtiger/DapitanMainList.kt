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
import com.example.foodtiger.databinding.ActivityDapitanMainListBinding

class DapitanMainList : AppCompatActivity() {

    private lateinit var binding: ActivityDapitanMainListBinding
    private lateinit var listAdapter: DapitanListAdapter
    private lateinit var listData: DapitanListData
    var dataArrayList = ArrayList<DapitanListData?>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dapitan_main_list)
        binding = ActivityDapitanMainListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nameList = arrayOf("Angkong", "Army Navy", "Bok Chicken", "Dimsum Treats", "Good Munch", "Jollibee", "Lovelite", "Tiger Winx", "Tomo Coffee", "Wendy's")
        val addresslist = arrayOf(
            "Gelinos St, Santa Cruz, Manila, 1008 Metro Manila",
            "Ground Floor, Pacific Icon Residences, Dapitan St, Sampaloc, Manila, Metro Manila",
            "1240 Asturias St, Sampaloc, Manila, 1008 Metro Manila",
            "cor Dapitan St, Sampaloc, Manila, 1008 Metro Manila",
            "1345 Dapitan St, Sampaloc, Manila, 1015 Metro Manila",
            "1523 Dapitan St, Sampaloc, Manila, 1015 Metro Manila",
            "1355 Dapitan St, San Miguel, Manila, 1008 Metro Manila",
            "1240 Concepcion St, Sampaloc, Manila, 1015 Metro Manila",
            "1427 Dapitan St, Sampaloc, Manila, 1015 Metro Manila",
            "1427 Dapitan St, Sampaloc, Manila, 1008 Metro Manila"


        )

        val operatinghourslist = arrayOf(
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",
            "Mon-Sun 9am - 9pm",



        )

        val imageList = intArrayOf(
            R.drawable.angkong,
            R.drawable.armynavy,
            R.drawable.bokchicken,
            R.drawable.dimsumtreats,
            R.drawable.goodmunch,
            R.drawable.jollibee,
            R.drawable.lovelite,
            R.drawable.tigerwinx,
            R.drawable.tomo,
            R.drawable.wendys
            )

        val menuList = intArrayOf(
            R.drawable.angkongmenu,
            R.drawable.armynavymenu,
            R.drawable.bokchickenmenu,
            R.drawable.dimsumtreatsmenu,
            R.drawable.goodmunchmenu,
            R.drawable.jollibeemenu,
            R.drawable.lovelitemenu,
            R.drawable.tigewinxmenu,
            R.drawable.tomomenu,
            R.drawable.wendysmenu
        )

        for (i in imageList.indices){
            listData = DapitanListData(nameList[i], addresslist[i], operatinghourslist[i], menuList[i], imageList[i])
            dataArrayList.add(listData)
        }


        listAdapter = DapitanListAdapter(this@DapitanMainList, dataArrayList)
        binding.dapitanlistview.adapter = listAdapter
        binding.dapitanlistview.isClickable = true


        binding.dapitanlistview.onItemClickListener = AdapterView.OnItemClickListener{ adapterView, view, i, l ->
            val intent = Intent(this@DapitanMainList, DapitanDetailed::class.java)
            intent.putExtra("name", nameList[i])
            intent.putExtra("address", addresslist[i])
            intent.putExtra("operatinghours", operatinghourslist[i])
            intent.putExtra("image", imageList[i])
            intent.putExtra("menu", menuList[i])
            startActivity(intent)


            var backBtn1 = findViewById<ImageButton>(R.id.btn_back1)

            backBtn1.setOnClickListener {
                val intent = Intent(this@DapitanMainList, Categories::class.java)
                startActivity(intent)
            }
        }
    }
}