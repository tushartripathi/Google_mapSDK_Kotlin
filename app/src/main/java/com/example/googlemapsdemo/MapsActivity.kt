package com.example.googlemapsdemo

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.shapes.Shape
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.lifecycle.lifecycleScope
import com.example.googlemapsdemo.misc.*

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback{

    private lateinit var map: GoogleMap
    private val cameraViewport by lazy { CameraAndViewport() }
    private val typeAndStyle by lazy {
        TypeAndStyle()
    }
    private  val overlays by lazy { Overlays() }
    private val shapes by lazy { Shapes() }
    val sydney = LatLng(30.32004591189383, 78.0349846851728)
    val mussorie = LatLng(52.47176493046111, 10.47564898906995)
    val brazile = LatLng(-8.715240680896748, -57.31317868532762)
    val usa = LatLng(44.974394319823546, -104.1170865508011)

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

       val doonMartker =  map.addMarker(MarkerOptions()
               .position(sydney)
               .title("IN Doon ")
               .snippet("Random tet"))


//        val doonMartker2 =  map.addMarker(MarkerOptions()
//                .position(mussorie)
//                .title("IN MUssorie "))

               //.icon(fromVectorToBitmap(R.drawable.ic_location, Color.parseColor("#000000"))))
               //.icon(BitmapDescriptorFactory.defaultMarker(134f)))
        //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))
       // doonMartker.isDraggable=true


        doonMartker.tag = "Resturant"

//        lifecycleScope.launch {
//            delay(7000L)
//            doonMartker.remove()
//        }

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,12f))

       // map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraViewport.dehradun))

        map.uiSettings.apply {
            isZoomControlsEnabled = true
            isZoomGesturesEnabled = false
            isCompassEnabled = true
            isMyLocationButtonEnabled = true

            //isScrollGesturesEnabled= false     //  |
            //isTiltGesturesEnabled=true         //  | Featrue of maps
            //isMapToolbarEnabled =true          //  |
            //isCompassEnabled = true            //  |
        }

        requestingPermissions()

        // this will create a custom marker
        // map.setInfoWindowAdapter(CustomInfoAdapter(this))        // | THis class create a block with message
        //map.setPadding(0,0,100,100)                               // | when you click on the marker

        typeAndStyle.setMapStyle(map,this)

        //overlays.addGroundOverlay(map)            // | Add image to map with fixed size

        //shapes.addPolygon(map)            // | draw rectange with the coordinates
        //shapes.addCircle(map)             // | draw a circle with center and radiud

//lifecycleScope.launch {                   // | For drwaing line betweeen to
//  var shape = Shapes()                    // | two lat,log points
//        shape.addPolyLine(map)            // |
//}

   //     map.setOnMarkerClickListener(this)
      //  map.setOnMarkerDragListener(this)
      //  map.setMinZoomPreference(15f)
//      //  map.setMaxZoomPreference(18f)


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

//    override fun onMarkerClick(p0: Marker?) : Boolean{
////        if(p0 != null)
////          Toast.makeText(baseContext, "Market = "+ p0.tag as String,Toast.LENGTH_SHORT).show()
////        else
////            Toast.makeText(baseContext, "Empty mrkaer" as String,Toast.LENGTH_SHORT).show()
//            return false
//    }


//    override fun onMarkerDragEnd(p0: Marker?) {
//        Toast.makeText(baseContext,"location = "+p0?.position?.latitude + " - " + p0?.position?.longitude , Toast.LENGTH_SHORT).show() }
//
//    override fun onMarkerDragStart(p0: Marker?) {
//    }
//
//    override fun onMarkerDrag(p0: Marker?) {
//
//    }



//    //Convert Vector to bitmap
//    private fun fromVectorToBitmap(id: Int, color:Int):BitmapDescriptor
//    {
//        val vectorDrawable:Drawable? = ResourcesCompat.getDrawable(resources, id, null)
//        if(vectorDrawable == null)
//            return BitmapDescriptorFactory.defaultMarker()
//
//            val bitmap = Bitmap.createBitmap(
//            vectorDrawable.intrinsicWidth,
//            vectorDrawable.intrinsicHeight,
//            Bitmap.Config.ARGB_8888)
//
//        val canvas = Canvas(bitmap)
//        vectorDrawable.setBounds(0,0,canvas.width, canvas.height)
//        DrawableCompat.setTint(vectorDrawable, color)
//        vectorDrawable.draw(canvas)
//        return BitmapDescriptorFactory.fromBitmap(bitmap)
//    }

    @RequiresApi(Build.VERSION_CODES.M)
    private  fun checkLocationPermission()
    {
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED)
        {
            map.isMyLocationEnabled =true
            Toast.makeText(this, "allready enable ", Toast.LENGTH_SHORT).show()
        }
        else
        {
            requestingPermissions()
        }
    }

    private fun requestingPermissions()
    {
        ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                1
        )
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 1  && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            map.isMyLocationEnabled =true
            Toast.makeText(this,"Permisson granted ", Toast.LENGTH_SHORT).show()
        }
    }

}