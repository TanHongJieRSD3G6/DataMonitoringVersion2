package com.madassignment.datamonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.protobuf.DescriptorProtos

class MainActivity : AppCompatActivity() {
    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val proceed: Button = findViewById(R.id.btnProceed)

        proceed.setOnClickListener{
            intent = Intent(applicationContext, AssistanceFunction::class.java)
            startActivity(intent)
        }

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync{
            googleMap = it

            val genPlant = LatLng(3.15169,101.71123)

            googleMap.addMarker(MarkerOptions().position(genPlant).title("Genting Plantation Johor"))

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(genPlant, 17f))

            val administration = LatLng(3.15159, 101.71120)

            googleMap.addMarker(MarkerOptions().position(administration).title("Administration"))

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(administration, 17f))

            val finance = LatLng(3.15190, 101.71115)

            googleMap.addMarker(MarkerOptions().position(finance).title("Finance"))

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(finance, 17f))

            val operation = LatLng(3.15190, 101.71138)

            googleMap.addMarker(MarkerOptions().position(operation).title("Operation").icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(finance, 17f))

            val research = LatLng(3.15180, 101.71123)

            googleMap.addMarker(MarkerOptions().position(research).title("Research").icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(research, 17f))

            val secretRoom = LatLng(3.15180, 101.71150)

            googleMap.addMarker(MarkerOptions().position(secretRoom).title("Secret Room"))

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(research, 17f))

            val meetingRoom = LatLng(3.15159, 101.71140)

            googleMap.addMarker(MarkerOptions().position(meetingRoom).title("Meeting Room"))

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(meetingRoom, 17f))

            val production = LatLng(3.15159, 101.71150)

            googleMap.addMarker(MarkerOptions().position(production).title("Production"))

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(production, 17f))
        }
    }
}