package joy.liu.com.hencoderPractice.practice3

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import joy.liu.com.hencoderPractice.PageFragment
import joy.liu.com.hencoderPractice.PageModel
import joy.liu.com.practicedraw1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity3 : AppCompatActivity() {
    private val pageModels: ArrayList<PageModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageModels.apply {
            add(PageModel(R.string.title_draw_text,R.layout.fragment_draw_text))
            add(PageModel(R.string.title_static_layout,R.layout.fragment_static_layout))
            add(PageModel(R.string.title_font_spacing,R.layout.fragment_get_font_spacing))
            add(PageModel(R.string.title_measure_text,R.layout.fragment_measure_text))
            add(PageModel(R.string.title_get_text_bound,R.layout.fragment_get_text_bound))
            add(PageModel(R.string.title_get_font_metrics,R.layout.fragment_get_font_metrics))
        }

        //kotlin 对象表达式（object）代替 java 中的匿名函数
        pager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {

            override fun getItem(position: Int): Fragment {
                val pageModel: PageModel = pageModels?.get(position) ?: PageModel(0, 0)
                return PageFragment.newInstance(pageModel.practiceLayoutRes)
            }

            override fun getCount(): Int {
                //如果pageModels不为空则返回size，否则返回0
                return pageModels?.size ?: 0
            }

            override fun getPageTitle(position: Int): CharSequence {
                return getString((pageModels?.get(position))?.titleRes ?: 0)

            }

        }

        tabLayout.setupWithViewPager(pager)
    }
}
