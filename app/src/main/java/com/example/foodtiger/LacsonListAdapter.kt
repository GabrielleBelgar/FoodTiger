package com.example.foodtiger

import android.widget.ArrayAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class LacsonListAdapter(context: Context, dataArrayList: ArrayList<LacsonListData?>?):
ArrayAdapter<LacsonListData?>(context, R.layout.lacsonlist, dataArrayList!!){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
        val LacsonListData = getItem(position)

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.lacsonlist, parent, false)

        }
        val listImage : ImageView = view!!.findViewById<ImageView>(R.id.listImage)
        val listName : TextView = view!!.findViewById<TextView>(R.id.listname)


        listImage.setImageResource(LacsonListData!!.image)
        listImage.setImageResource(LacsonListData!!.menu)
        listName.text = LacsonListData.name


        return view

    }

}