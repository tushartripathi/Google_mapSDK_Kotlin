package com.example.googlemapsdemo.misc

import android.graphics.Color
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.PolylineOptions
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
                }
        )
    }
}