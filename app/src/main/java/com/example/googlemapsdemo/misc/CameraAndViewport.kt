package com.example.googlemapsdemo.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class CameraAndViewport {
    val dehradun: CameraPosition = CameraPosition.Builder()
        .target(LatLng(28.457304950838353, 77.02581957404261))
        .zoom(17f)
        .bearing(100f)
        .tilt(45f)
        .build()

    val mussorie = LatLngBounds(LatLng(20.450049945822474, 68.18231329624398)
                              , LatLng(30.183566552937886, 78.17318750509011))
}