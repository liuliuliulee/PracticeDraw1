package joy.liu.com.hencoderPractice.practice1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import joy.liu.com.hencoderPractice.PageFragment
import joy.liu.com.hencoderPractice.PageModel
import joy.liu.com.practicedraw1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity1 : AppCompatActivity() {
    val pageModels: ArrayList<PageModel?>? = ArrayList()

    //当类加载的时候，会初始化伴生对象，与 Java 的静态代码块一样。
    companion object {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageModels?.apply {
            add(PageModel(R.string.title_draw_pie_chart, R.layout.fragment_draw_pie_chart))
            add(PageModel(R.string.title_draw_histogram, R.layout.fragment_draw_histogram))
            add(PageModel(R.string.title_draw_path, R.layout.fragment_draw_path))
            add(PageModel(R.string.title_draw_arc, R.layout.fragment_draw_arc))
            add(PageModel(R.string.title_draw_color, R.layout.fragment_draw_color))
            add(PageModel(R.string.title_draw_circle, R.layout.fragment_draw_circle))
            add(PageModel(R.string.title_draw_rect, R.layout.fragment_draw_rect))
            add(PageModel(R.string.title_draw_line, R.layout.fragment_draw_line))
            add(PageModel(R.string.title_draw_oval, R.layout.fragment_draw_oval))
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

        // tabLayout 是 xml 中 android.support.design.widget.TabLayout 的 id
        tabLayout.setupWithViewPager(pager)

    }

}
