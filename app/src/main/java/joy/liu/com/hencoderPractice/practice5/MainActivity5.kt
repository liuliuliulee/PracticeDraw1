package joy.liu.com.hencoderPractice.practice5

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import joy.liu.com.hencoderPractice.PageFragment
import joy.liu.com.hencoderPractice.PageModel
import joy.liu.com.practicedraw1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity5 : AppCompatActivity() {
    private val pageModels: ArrayList<PageModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageModels.apply {
            add(PageModel(R.string.title_after_on_draw, R.layout.fragment_after_on_draw))
            add(PageModel(R.string.title_before_on_draw, R.layout.fragment_before_on_draw))
            add(PageModel(R.string.title_on_draw_layout, R.layout.fragment_on_draw_layout))
            add(PageModel(R.string.title_dispatch_draw, R.layout.fragment_dispatch_draw_layout))
            add(PageModel(R.string.title_after_on_draw_foreground, R.layout.fragment_after_on_draw_foreground))
            add(PageModel(R.string.title_before_on_draw_foreground, R.layout.fragment_before_on_draw_foreground))
            add(PageModel(R.string.title_after_draw, R.layout.fragment_after_draw))
            add(PageModel(R.string.title_before_draw, R.layout.fragment_before_draw))
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