package com.example.foodtiger

import android.widget.ArrayAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class EspanaListAdapter(context: Context, dataArrayList: ArrayList<EspanaListData?>?):
ArrayAdapter<EspanaListData?>(context, R.layout.espanalist, dataArrayList!!){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
        val EspanaListData = getItem(position)

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.espanalist, parent, false)

        }
        val listImage : ImageView = view!!.findViewById<ImageView>(R.id.listImage)
        val listName : TextView = view!!.findViewById<TextView>(R.id.listname)


        listImage.setImageResource(EspanaListData!!.image)
        listImage.setImageResource(EspanaListData!!.menu)
        listName.text = EspanaListData.name


        return view

    }

}