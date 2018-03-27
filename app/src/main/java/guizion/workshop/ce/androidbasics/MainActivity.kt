package guizion.workshop.ce.androidbasics

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView

interface SelectInModalListener {
    fun onSelectInModal(type: Int, value: String)
}

class MainActivity: AppCompatActivity(), SelectInModalListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener({ menuItem ->
            drawerLayout.closeDrawers()
            onNavDrawerItemSelected(menuItem)
            true
        })

        val toolbar = findViewById<Toolbar>(R.id.toolbar_home)
        val drawerToggle = object : ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer) { }
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
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
        modal.show(supportFragmentManager, "selectModalFragment")
    }

    override fun onSelectInModal(type: Int, value: String) {
        val txt: TextView? = when(type) {
            R.array.pizzas -> findViewById(R.id.pizza)
            R.array.sizes -> findViewById(R.id.size)
            R.array.borders -> findViewById(R.id.border)
            else -> null
        }
        txt?.text = value
        val fragment = this.supportFragmentManager.findFragmentByTag("selectModalFragment")
        (fragment as BottomSheetDialogFragment).dismiss()
    }
}