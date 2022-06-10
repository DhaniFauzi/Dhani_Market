package com.example.dhani_market.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.dhani_market.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView:BottomNavigationView=findViewById(R.id.nav_view)
        val appBarConfiguration= AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_order, R.id.navigation_profile
            )
        )
        val navController= Navigation.findNavController(this,R.nav_host_fragment)
        NavigationUI.setupWithNavController(navView, navController)
    }
}