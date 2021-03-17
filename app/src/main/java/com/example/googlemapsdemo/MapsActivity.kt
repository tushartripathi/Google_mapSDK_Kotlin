package com.example.googlemapsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.googlemapsdemo.misc.CameraAndViewport
import com.example.googlemapsdemo.misc.TypeAndStyle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var map: GoogleMap
    private val cameraViewport by lazy { CameraAndViewport() }
    private val typeAndStyle by lazy {
        TypeAndStyle()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        typeAndStyle.setMapTyoe(item, map)
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(30.32004591189383, 78.0349846851728)
       val doonMartker =  map.addMarker(MarkerOptions().position(sydney).title("IN Doon "))


        doonMartker.tag = "Resturant"
//        lifecycleScope.launch {
//            delay(7000L)
//            doonMartker.remove()
//        }
       // map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,10f))
       // map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraViewport.dehradun))
        map.uiSettings.apply {
            isZoomControlsEnabled = true
            isZoomGesturesEnabled = false
            //isScrollGesturesEnabled= false
            isMyLocationButtonEnabled = true
            //isTiltGesturesEnabled=true
           // isMapToolbarEnabled =true
            isCompassEnabled = true
        }

        //map.setPadding(0,0,100,100)
        typeAndStyle.setMapStyle(map,this)
        map.setOnMarkerClickListener(this)
      //  map.setMinZoomPreference(15f)
//      //  map.setMaxZoomPreference(18f)
//
//        lifecycleScope.launch {
//            delay(7000L)
//            map.moveCamera(CameraUpdateFactory.zoomBy(.1f))
//            delay(1000L)
//            map.moveCamera(CameraUpdateFactory.zoomBy(.1f))
//            delay(1000L)
//            map.moveCamera(CameraUpdateFactory.zoomBy(.1f))
//        }

//        lifecycleScope.launch {
//            delay(7000L)
//            //map.moveCamera(CameraUpdateFactory.newLatLng(LatLng(30.32004591189383, 78.0349846851728)))
//           // map.moveCamera(CameraUpdateFactory.scrollBy(30f, 78f))
//
//            map.animateCamera(CameraUpdateFactory.newLatLngBounds(cameraViewport.mussorie,0) , 3000, null)
//
////            map.setOnMapClickListener {
////                Toast.makeText(baseContext, "short click", Toast.LENGTH_SHORT).show()
////            }
////
////            map.setOnMapLongClickListener {
////                Toast.makeText(baseContext, "LOng click" + it.longitude + " - " + it.latitude, Toast.LENGTH_SHORT).show()
////            }
//        }
    }

    override fun onMarkerClick(p0: Marker?) : Boolean{
        if(p0 != null)
          Toast.makeText(baseContext, "Market = "+ p0.tag as String,Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(baseContext, "Empty mrkaer" as String,Toast.LENGTH_SHORT).show()
            return false
    }


}