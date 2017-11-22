package joy.liu.com.hencoderPractice.practice7

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/16.
 */
class Sample04PropertyValuesHolderLayout : RelativeLayout {
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
            val holder1 = PropertyValuesHolder.ofFloat("scaleX", 0f, 1f)
            val holder2 = PropertyValuesHolder.ofFloat("scaleY", 0f, 1f)
            val holder3 = PropertyValuesHolder.ofFloat("alpha", 0f, 1f)
            val holder4 = PropertyValuesHolder.ofFloat("rotationX", 0f, 720f)
            val holder5 = PropertyValuesHolder.ofFloat("rotation", 0f, 720f)

            ObjectAnimator.ofPropertyValuesHolder(view,holder1,holder2,holder3,holder4,holder5).setDuration(3000).start()
        })
    }

}