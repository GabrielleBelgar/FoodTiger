package com.example.foodtiger

import android.widget.ArrayAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class PnovalListAdapter(context: Context, dataArrayList: ArrayList<PnovalListData?>?):
ArrayAdapter<PnovalListData?>(context, R.layout.pnovallist, dataArrayList!!){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
        val PnovalListData = getItem(position)

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.pnovallist, parent, false)

        }
        val listImage : ImageView = view!!.findViewById<ImageView>(R.id.listImage)
        val listName : TextView = view!!.findViewById<TextView>(R.id.listname)


        listImage.setImageResource(PnovalListData!!.image)
        listImage.setImageResource(PnovalListData!!.menu)
        listName.text = PnovalListData.name


        return view

    }

}