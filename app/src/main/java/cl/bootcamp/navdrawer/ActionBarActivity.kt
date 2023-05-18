package cl.bootcamp.navdrawer
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
open class ActionBarActivity : AppCompatActivity(), IActionBarApp {

    lateinit var _toolbar: Toolbar

    override fun loadActionBarInActivity(toolbar: Toolbar) {

        _toolbar = toolbar
        _toolbar.let {
            setSupportActionBar(toolbar)
        }
    }


}