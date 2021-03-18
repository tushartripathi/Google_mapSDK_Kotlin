package com.example.googlemapsdemo.misc

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.TextView
import com.example.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class CustomInfoAdapter(context : Context) : GoogleMap.InfoWindowAdapter
{

    private val contextView  = (context as Activity).layoutInflater.inflate(R.layout.custom_info_window, null)
    override fun getInfoContents(p0: Marker?): View {
        renderView(p0,contextView)
        return contextView
    }

    override fun getInfoWindow(p0: Marker?): View {
            renderView(p0,contextView)
        return contextView
    }

    fun renderView(marker:Marker?, view:View)
    {
        val title = marker?.title
        val desctiption = marker?.snippet
        val titleTextView = view.findViewById<TextView>(R.id.titleText_Id)
        titleTextView.text = title
        val descTextView = view.findViewById<TextView>(R.id.descTextView_Id)
        descTextView.text = desctiption
    }

}