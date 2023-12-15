package com.example.foodtiger

import android.widget.ArrayAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DapitanListAdapter(context: Context, dataArrayList: ArrayList<DapitanListData?>?):
ArrayAdapter<DapitanListData?>(context, R.layout.dapitanlist, dataArrayList!!){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
        val DapitanListData = getItem(position)

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.dapitanlist, parent, false)

        }
        val listImage : ImageView = view!!.findViewById<ImageView>(R.id.listImage)
        val listName : TextView = view!!.findViewById<TextView>(R.id.listname)


        listImage.setImageResource(DapitanListData!!.image)
        listImage.setImageResource(DapitanListData!!.menu)
        listName.text = DapitanListData.name


        return view

    }

}