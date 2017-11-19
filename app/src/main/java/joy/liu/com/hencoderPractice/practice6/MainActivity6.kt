package joy.liu.com.hencoderPractice.practice6

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import joy.liu.com.hencoderPractice.PageFragment
import joy.liu.com.hencoderPractice.PageModel
import joy.liu.com.practicedraw1.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.locks.ReentrantLock

class MainActivity6 : AppCompatActivity() {
    private val pageModels: ArrayList<PageModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageModels.apply {
            add(PageModel(R.string.title_translate, R.layout.fragment_translation))
            add(PageModel(R.string.title_rotation, R.layout.fragment_rotation))
            add(PageModel(R.string.title_scale, R.layout.fragment_animation_scale))
            add(PageModel(R.string.title_alpha, R.layout.fragment_animation_alpha))
            add(PageModel(R.string.title_multi_properties, R.layout.fragment_animation_multi_properties))
            add(PageModel(R.string.title_rotation, R.layout.fragment_animation_duration))
            add(PageModel(R.string.title_interpolator, R.layout.fragment_animation_interpolator))
            add(PageModel(R.string.title_object_animator, R.layout.fragment_animation_object))
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

        val reentrantLock = ReentrantLock(false)
        reentrantLock.lock()
        reentrantLock.unlock()

        tabLayout.setupWithViewPager(pager)
    }
}