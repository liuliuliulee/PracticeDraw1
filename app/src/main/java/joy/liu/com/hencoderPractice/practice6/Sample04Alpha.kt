package joy.liu.com.hencoderPractice.practice6

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/16.
 */
class Sample04Alpha : RelativeLayout {
    var animateBt: Button? = null
    var imageView: ImageView? = null
    var state = 0

    constructor(context: Context) : super(context) {
        initData()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initData()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initData()
    }

    private fun initData() {

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animateBt = findViewById(R.id.animateBt)
        imageView = findViewById(R.id.imageView)
        animateBt?.setOnClickListener { v ->
            when (state) {
                0 -> imageView?.animate()?.alpha(0f)
                1 -> imageView?.animate()?.alpha(0.5f)
                2 -> imageView?.animate()?.alpha(1f)
            }
            state++
            if(state==3)
                state=0
        }
    }

}