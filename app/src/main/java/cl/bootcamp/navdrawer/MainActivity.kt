package cl.bootcamp.navdrawer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import cl.bootcamp.navdrawer.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

lateinit var bindingMain: ActivityMainBinding

class MainActivity : ActionBarActivity(), IActionBarApp,
    NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        _toolbar = findViewById<Toolbar>(R.id.toolbar_id)

        loadActionBarInActivity(_toolbar)

        configurationDrawer()
    }

    private fun configurationDrawer() {

        var toogle = ActionBarDrawerToggle(
            this, bindingMain.drawerLayout, _toolbar,
            R.string.drawerClose, R.string.drawerOpen
        )

        toogle.isDrawerIndicatorEnabled
        bindingMain.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        bindingMain.navigation.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        return true
    }


}