package joy.liu.com.hencoderPractice.practice2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import joy.liu.com.hencoderPractice.PageFragment
import joy.liu.com.hencoderPractice.PageModel
import joy.liu.com.practicedraw1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity2 : AppCompatActivity() {
    private val pageModels: ArrayList<PageModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageModels.apply {
            add(PageModel(R.string.title_fill_path,R.layout.fragment_fill_path))
            add(PageModel(R.string.title_text_path,R.layout.fragment_text_path))
            add(PageModel(R.string.title_linear_gradient,R.layout.fragment_linear_gradient))
            add(PageModel(R.string.title_radia_gradient,R.layout.fragment_radia_gradient))
            add(PageModel(R.string.title_sweep_gradient,R.layout.fragment_sweep_gradient))
            add(PageModel(R.string.title_bitmap_shader,R.layout.fragment_bitmap_shader))
            add(PageModel(R.string.title_compose_shader,R.layout.fragment_compose_shader))
            add(PageModel(R.string.title_color_matrix_color,R.layout.fragment_color_matrix_color))
            add(PageModel(R.string.title_xfermode,R.layout.fragment_xfermode))
            add(PageModel(R.string.title_stroke_cap,R.layout.fragment_stroke_cap))
            add(PageModel(R.string.title_stroke_join,R.layout.fragment_stroke_join))
            add(PageModel(R.string.title_stroke_miter,R.layout.fragment_stroke_miter))
            add(PageModel(R.string.title_path_effect,R.layout.fragment_path_effect))
            add(PageModel(R.string.title_shadow_layer,R.layout.fragment_shadow_layer))
            add(PageModel(R.string.title_mask_filter,R.layout.fragment_mask_filter))
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
