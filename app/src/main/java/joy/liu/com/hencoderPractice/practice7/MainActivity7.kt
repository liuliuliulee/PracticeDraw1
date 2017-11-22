package joy.liu.com.hencoderPractice.practice7

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import joy.liu.com.hencoderPractice.PageFragment
import joy.liu.com.hencoderPractice.PageModel
import joy.liu.com.practicedraw1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity7 : AppCompatActivity() {
    private val pageModels: ArrayList<PageModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageModels.apply {
            add(PageModel(R.string.title_argb_evaluator, R.layout.fragment_argb_evaluator))
            add(PageModel(R.string.title_hsv_evaluator, R.layout.fragment_hsv_evaluator))
            add(PageModel(R.string.title_of_object, R.layout.fragment_of_object))
            add(PageModel(R.string.title_property_values_holder, R.layout.fragment_property_values_holder))
            add(PageModel(R.string.title_animator_set, R.layout.fragment_animator_set))
            add(PageModel(R.string.title_keyframe, R.layout.fragment_keyframe))
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