package joy.liu.com.hencoderPractice.practice7

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.RelativeLayout
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/16.
 */
class Sample01ArgbEvaluatorLayout_ : RelativeLayout {
    var view: Sample01ArgbEvaluatorView_? = null
    var animateBt: Button? = null


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
        view = findViewById(R.id.objectAnimatorView)
        animateBt = findViewById(R.id.animateBt)

        animateBt?.setOnClickListener({
            val objectAnimator = ObjectAnimator.ofInt(view, "color", 0xff0000, 0x00ff00)
            objectAnimator.setEvaluator(ArgbEvaluator())
            objectAnimator.duration=2000
            objectAnimator.start()
        })
    }

}