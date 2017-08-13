package joy.liu.com.practicedraw1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub

/**
 * Created by joy on 2017/7/22.
 */
class PageFragment : Fragment() {
    //    var sampleLayoutRes = 0
    var practiceLayoutRes = 0

    //伴生对象代替java静态成员变量或方法
    companion object {

        fun newInstance(practiceLayoutRes: Int): PageFragment {
            val pageFragment = PageFragment()
            val bundle = Bundle()
//            bundle.putInt("sampleLayoutRes", sampleLayoutRes)
            bundle.putInt("practiceLayoutRes", practiceLayoutRes)
            pageFragment.arguments = bundle
            return pageFragment
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(arguments) {
            //sampleLayoutRes = getInt("sampleLayoutRes")
            practiceLayoutRes = getInt("practiceLayoutRes")
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_page, container, false)
//        sampleStub.layoutResource = sampleLayoutRes
//        sampleStub.inflate()
        val practiceStub = view?.findViewById(R.id.practiceStub) as ViewStub
        practiceStub.layoutResource = practiceLayoutRes
        practiceStub.inflate()

        return view
    }


}