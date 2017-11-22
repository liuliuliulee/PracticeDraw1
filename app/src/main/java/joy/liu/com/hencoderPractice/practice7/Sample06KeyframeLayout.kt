package joy.liu.com.hencoderPractice.practice7

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.RelativeLayout
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/16.
 */
class Sample06KeyframeLayout : RelativeLayout {
    var view: Sample06KeyframeView? = null
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
            val key1 = Keyframe.ofFloat(0f, 0f)
            val key2 = Keyframe.ofFloat(0.5f, 100f)
            val key3 = Keyframe.ofFloat(1f, 80f)

            val holder = PropertyValuesHolder.ofKeyframe("progress", key1, key2, key3)
            val animator = ObjectAnimator.ofPropertyValuesHolder(view, holder)
            animator.duration=3000
            animator.start()


        })
    }

}