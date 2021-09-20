package com.madassignment.datamonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

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

            googleMap.addMarker(MarkerOptions().position(genPlant).title("GentingPlantationJohor"))

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(genPlant, 20f))
        }
    }
}