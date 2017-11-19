package joy.liu.com.hencoderPractice.practice6

import android.animation.ObjectAnimator
import android.content.Context
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.util.AttributeSet
import android.widget.Button
import android.widget.RelativeLayout
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/16.
 */
class Sample08ObjectAnimatorLayout : RelativeLayout {
    var view: Sample08ObjectAnimatorView? = null
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
        view = findViewById(R.id.objectAnimatorView);
        animateBt =  findViewById(R.id.animateBt);

        animateBt?.setOnClickListener( {
            val animator = ObjectAnimator.ofFloat(view, "progress", 0f, 65f)
            animator.duration = 1000
            animator.interpolator = FastOutSlowInInterpolator()
            animator.start()
        })
    }

}

