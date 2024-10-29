package coba.paba.latihanfragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    // Menyimpan nilai akhir yang akan ditampilkan di halaman 2
    var finalScore: Int = 0

    // Default batas angka random 1-5 untuk halaman 1
    var maxRandomNumber: Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Set default fragment (Fragment1) saat activity pertama kali dibuat
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment1()) // Pastikan Fragment1 ada dan benar
                .commit()
        }
    }

    // Inflate the menu for navigation
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu) // Pastikan file top_menu ada di folder res/menu
        return true
    }

    // Handle menu item clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var selectedFragment: Fragment? = null

        // Pilih fragment berdasarkan item menu yang diklik
        when (item.itemId) {
            R.id.nav_page1 -> selectedFragment = Fragment1() // Pastikan Fragment1 benar
            R.id.nav_page2 -> selectedFragment = Fragment2() // Pastikan Fragment2 benar
            R.id.nav_page3 -> selectedFragment = Fragment3() // Pastikan Fragment3 benar
        }

        // Ganti fragment jika selectedFragment tidak null
        if (selectedFragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit()
        }

        return super.onOptionsItemSelected(item)
    }
}
