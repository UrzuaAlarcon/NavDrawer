package cl.bootcamp.navdrawer

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cl.bootcamp.navdrawer.databinding.ActivityMainBinding
import cl.bootcamp.navdrawer.fragments.HomeFragment
import cl.bootcamp.navdrawer.fragments.LlegadasFragment
import cl.bootcamp.navdrawer.fragments.SalidasFragment
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

        setAppInformation()

        if (savedInstanceState == null) fragmentTransaction(HomeFragment())

    }

    private fun configurationDrawer() {

        var toogle = ActionBarDrawerToggle(
            this, bindingMain.drawerLayout, _toolbar,
            R.string.drawerClose, R.string.drawerOpen
        )

        toogle.isDrawerIndicatorEnabled
        bindingMain.drawerLayout.addDrawerListener(toogle)

        bindingMain.navigation.menu.getItem(0).isChecked = true

        toogle.syncState()
        bindingMain.navigation.setNavigationItemSelectedListener(this)

    }

    private fun fragmentTransaction(fragment: Fragment) {

        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()

    }

    private fun loadFragmentById(idFragment: Int) {

        when (idFragment) {

            R.id.home -> fragmentTransaction(HomeFragment())
            R.id.llegadas -> fragmentTransaction(LlegadasFragment())
            R.id.salidas -> fragmentTransaction(SalidasFragment())

        }
    }

    private fun loadOtheroptions(idOptions: Int) {

        when (idOptions) {

            R.id.perfil -> Toast.makeText(
                this, "aca va el perfil de usuario",
                Toast.LENGTH_LONG
            ).show()

            R.id.configuracion -> Toast.makeText(
                this, "aca va la configuracion de la app",
                Toast.LENGTH_LONG
            ).show()


        }


    }

    private fun setAppInformation() {

        var name = bindingMain.navigation.getHeaderView(0).findViewById<TextView>(R.id.txtInfo)

        name?.let {

            name.text = "Nombre de usuario desde la API"

        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        loadFragmentById(item.itemId)
        loadOtheroptions(item.itemId)
        bindingMain.drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }


}