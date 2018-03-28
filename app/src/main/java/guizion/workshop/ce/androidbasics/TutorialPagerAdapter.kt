package guizion.workshop.ce.androidbasics

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater

class TutorialPagerAdapter: PagerAdapter() {
    private val tutorialPages = intArrayOf(R.layout.tutorial_first_step, R.layout.tutorial_second_step, R.layout.tutorial_third_step)

    override fun isViewFromObject(view: View?, obj: Any?): Boolean {
        return view == obj
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any? {
        val layoutInflater = container?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(tutorialPages[position], null)
        (container as ViewPager).addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

    }

    override fun getCount(): Int {
        return tutorialPages.size
    }
}