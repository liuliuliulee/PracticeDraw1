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
class Sample02Rotation : RelativeLayout {
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
                0 -> imageView?.animate()?.rotation(180f)
                1 -> imageView?.animate()?.rotation(0f)
                2 -> imageView?.animate()?.rotationX(180f)
                3 -> imageView?.animate()?.rotationX(0f)
                4 -> imageView?.animate()?.rotationY(180f)
                5 -> imageView?.animate()?.rotationY(0f)
            }
            state++
            if(state==6)
                state=0
        }
    }

}