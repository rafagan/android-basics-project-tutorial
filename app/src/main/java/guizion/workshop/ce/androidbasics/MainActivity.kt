package guizion.workshop.ce.androidbasics

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.view.View


class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener({ menuItem ->
            val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
            drawerLayout.closeDrawers()
            onNavDrawerItemSelected(menuItem)
            true
        })
    }

    override fun onResume() {
        super.onResume()
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.menu.getItem(0).isChecked = true
    }

    fun onNavDrawerItemSelected(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.menu_title_item -> navigateToHistory()
        }
    }

    fun navigateToHistory() {
        val myIntent = Intent(this, HistoryActivity::class.java)
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(myIntent)
    }

    fun showPizzas(view: View) {
        showModal(R.array.pizzas)
    }

    fun showSizes(view: View) {
        showModal(R.array.sizes)
    }

    fun showBorders(view: View) {
        showModal(R.array.borders)
    }

    fun showModal(type: Int) {
        val modal = SelectModalFragment()
        val bundle = Bundle()
        bundle.putInt("type", type)
        modal.arguments = bundle
        modal.show(supportFragmentManager, null)
    }
}