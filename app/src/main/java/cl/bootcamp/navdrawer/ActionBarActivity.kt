package cl.bootcamp.navdrawer
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import cl.bootcamp.navdrawer.interfaces.IActionBarApp

open class ActionBarActivity : AppCompatActivity(), IActionBarApp {

    lateinit var _toolbar: Toolbar

    override fun loadActionBarInActivity(toolbar: Toolbar) {

        _toolbar = toolbar
        _toolbar.let {
            setSupportActionBar(toolbar)
        }
    }


}