package joy.liu.com.hencoderPractice.practice7

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.PointF
import android.util.AttributeSet
import android.widget.Button
import android.widget.RelativeLayout
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/16.
 */
class Sample03OfObjectLayout : RelativeLayout {
    var view: Sample03OfObjectView? = null
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
            val objectAnimator = ObjectAnimator.ofObject(view, "position", PointFEvaluator(),
                    PointF(0f, 0f), PointF(1f, 1f))
            objectAnimator.duration = 2000
            objectAnimator.start()
        })
    }

    inner class PointFEvaluator : TypeEvaluator<PointF> {
        var newPoint = PointF()
        override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
            var x = startValue.x + (fraction * (endValue.x - startValue.x))
            var y = startValue.y + (fraction * (endValue.y - startValue.y))
            newPoint.set(x, y)
            return newPoint
        }

    }

}