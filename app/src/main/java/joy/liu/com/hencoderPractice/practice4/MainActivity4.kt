package joy.liu.com.hencoderPractice.practice4

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import joy.liu.com.hencoderPractice.PageFragment
import joy.liu.com.hencoderPractice.PageModel
import joy.liu.com.practicedraw1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity4 : AppCompatActivity() {
    private val pageModels: ArrayList<PageModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageModels.apply {
            add(PageModel(R.string.title_canvas_scale, R.layout.fragment_canvas_scale))
            add(PageModel(R.string.title_clip_rect, R.layout.fragment_clip_rect))
            add(PageModel(R.string.title_clip_path, R.layout.fragment_clip_rect))
            add(PageModel(R.string.title_translate, R.layout.fragment_translate))
            add(PageModel(R.string.title_scale, R.layout.fragment_scale))
            add(PageModel(R.string.title_rotate, R.layout.fragment_rotate))
            add(PageModel(R.string.title_skew, R.layout.fragment_skew))
            add(PageModel(R.string.title_matrix_translate, R.layout.fragment_matrix_translate))
            add(PageModel(R.string.title_matrix_scale, R.layout.fragment_matrix_scale))
            add(PageModel(R.string.title_matrix_rotate, R.layout.fragment_matrix_rotate))
            add(PageModel(R.string.title_camera_rotate, R.layout.fragment_camera_rotate))
            add(PageModel(R.string.title_camera_rotate_fix, R.layout.fragment_camera_rotate_fix))
            add(PageModel(R.string.title_camera_rotate_hitting, R.layout.fragment_camera_rotate_hitting))
            add(PageModel(R.string.title_camera_flipboard, R.layout.fragment_camera_flipboard))
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