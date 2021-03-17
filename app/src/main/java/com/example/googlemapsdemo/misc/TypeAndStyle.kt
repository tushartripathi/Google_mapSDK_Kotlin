package com.example.googlemapsdemo.misc

import android.content.Context
import android.view.MenuItem
import android.widget.Toast
import com.example.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MapStyleOptions
import java.lang.Exception

class TypeAndStyle {

    fun setMapStyle(googleMap: GoogleMap, context: Context) {
        try {
            val success = googleMap.setMapStyle(MapStyleOptions
                    .loadRawResourceStyle
                    (context, R.raw.style))
            if (success)
                Toast.makeText(context, "Map Updated", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(context, "Failed!! to Updated", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    fun setMapTyoe(item : MenuItem , map:GoogleMap)
    {
        when(item.itemId)
        {
            R.id.normal_map_Id->{
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.satellite_map_Id->{
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }
            R.id.hybride_map_Id->{
                map.mapType = GoogleMap.MAP_TYPE_HYBRID
            }
            R.id.terrain_map_Id->{
                map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            }
            R.id.none_map_Id->{
                map.mapType = GoogleMap.MAP_TYPE_NONE
            }
        }
    }
}