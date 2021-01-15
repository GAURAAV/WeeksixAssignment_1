package com.gauravthapa.week6assignment1

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class Home_Activity : AppCompatActivity() {

    private var storage =  Storage()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_addStudent, R.id.navigation_aboutUs))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    override fun onBackPressed() {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Logout?")

        builder.setMessage("Do you want to logout?")

        builder.setIcon(android.R.drawable.ic_dialog_info)

        builder.setPositiveButton("YES"){ _, _ ->
            storage.setLoggedIn(null)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("msg", "Logged Out")
            startActivity(intent)
        }

        val alert: AlertDialog = builder.create()
        alert.setCancelable(true)
        alert.show()
    }
}
