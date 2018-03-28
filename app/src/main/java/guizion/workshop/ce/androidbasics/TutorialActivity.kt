package guizion.workshop.ce.androidbasics

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import me.relex.circleindicator.CircleIndicator

class TutorialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val indicator = findViewById<CircleIndicator>(R.id.indicator)

        viewPager.adapter = TutorialPagerAdapter()
        indicator.setViewPager(viewPager)
    }

    fun onCompleteTutorial(view: View) {
        val intent = Intent(this@TutorialActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
