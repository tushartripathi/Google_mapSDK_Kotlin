package com.example.googlemapsdemo.misc

import android.graphics.Color
import com.example.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.delay

class Shapes {
    val sydney = LatLng(30.32004591189383, 78.0349846851728)
    val mussorie = LatLng(52.47176493046111, 10.47564898906995)
    val brazile = LatLng(-8.715240680896748, -57.31317868532762)
    val usa = LatLng(44.974394319823546, -104.1170865508011)


    fun  addPolyLine(map:GoogleMap)
    {

                val polyLine = map.addPolyline(
                PolylineOptions().apply {
                    add(sydney,mussorie,usa)
                    width(5f)
                    color(Color.BLUE)
                    geodesic(true)
                })

       // delay(10000L)
        val newList = listOf(
                sydney,brazile,usa
        )

        polyLine.points = newList
    }

    fun addPolygon(map: GoogleMap)
    {
        val polygon = map.addPolygon(
                PolygonOptions().apply {
                    //add(sydney, mussorie, brazile,usa)
                    add(sydney,mussorie,brazile)
                    fillColor(R.color.black)
                    strokeColor(R.color.black)

                }
        )
    }

    fun addCircle(map:GoogleMap)
    {
        val circle = map.addCircle(
                CircleOptions().apply {
                    center(sydney)
                    radius(5000.0)
                    fillColor(R.color.design_default_color_primary)
                    strokeColor(R.color.black)
                    clickable(true)

                }
        )
    }
}