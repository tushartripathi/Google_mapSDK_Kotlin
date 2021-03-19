package com.example.googlemapsdemo.misc

import com.example.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*

class Overlays {
    val sydney = LatLng(30.32004591189383, 78.0349846851728)
    val sydneyBounds = LatLngBounds(
            LatLng(30.279783432991184, 78.00275858734636),
            LatLng(30.3888292356429, 78.07979378003459))
    fun addGroundOverlay(maps:GoogleMap)
    {
         maps.addGroundOverlay(
                GroundOverlayOptions().apply {
                    //osition(sydney, 1000f)
                    positionFromBounds(sydneyBounds)
                    image(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                }
        )
    }
}