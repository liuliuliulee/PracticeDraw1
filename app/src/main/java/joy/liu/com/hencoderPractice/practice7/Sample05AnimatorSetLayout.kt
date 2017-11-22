package joy.liu.com.hencoderPractice.practice7

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/16.
 */
class Sample05AnimatorSetLayout : RelativeLayout {
    var view: View? = null
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
            val animator1 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
            val animator2 = ObjectAnimator.ofFloat(view, "translationX", -200f, 200f)
            val animator3 = ObjectAnimator.ofFloat(view, "rotation", 0f, 1800f)
            animator3.duration = 2000
            animator1.duration = 2000
            animator2.duration = 2000

            val animatorSet = AnimatorSet()
            animatorSet.play(animator1).before(animator2)
            animatorSet.playTogether(animator2,animator3)
            animatorSet.start()
        })
    }

}