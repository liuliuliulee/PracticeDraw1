package joy.liu.com.practicedraw1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var pageModels: ArrayList<PageModel?>? = null

    //当类加载的时候，会初始化伴生对象，与 Java 的静态代码块一样。
    companion object {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageModels = ArrayList<PageModel?>()
        pageModels?.add(PageModel(R.string.title_draw_pie_chart, R.layout.fragment_draw_pie_chart))
        pageModels?.add(PageModel(R.string.title_draw_histogram, R.layout.fragment_draw_histogram))
        pageModels?.add(PageModel(R.string.title_draw_path, R.layout.fragment_draw_path))
        pageModels?.add(PageModel(R.string.title_draw_arc, R.layout.fragment_draw_arc))
        pageModels?.add(PageModel(R.string.title_draw_color, R.layout.fragment_draw_color))
        pageModels?.add(PageModel(R.string.title_draw_circle, R.layout.fragment_draw_circle))
        pageModels?.add(PageModel(R.string.title_draw_rect, R.layout.fragment_draw_rect))
        pageModels?.add(PageModel(R.string.title_draw_line, R.layout.fragment_draw_line))
        pageModels?.add(PageModel(R.string.title_draw_oval, R.layout.fragment_draw_oval))

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


    class PageModel(var titleRes: Int, var practiceLayoutRes: Int)
}
