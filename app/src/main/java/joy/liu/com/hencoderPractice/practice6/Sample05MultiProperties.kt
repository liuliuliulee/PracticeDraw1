package joy.liu.com.hencoderPractice.practice6

import android.animation.Animator
import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/16.
 */
class Sample05MultiProperties : RelativeLayout {
    var animateBt: Button? = null
    var imageView: ImageView? = null
    var animated = false
    var animating = false

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
        imageView?.scaleX = 0f
        imageView?.scaleY = 0f
        imageView?.alpha = 0f

        animateBt?.setOnClickListener { v ->
            if (!animating) {
                if (!animated) {
                    imageView
                            ?.animate()
                            ?.translationX(200f)
                            ?.rotation(360f)
                            ?.scaleX(1f)
                            ?.scaleY(1f)
                            ?.alpha(1f)
                            ?.setDuration(2000)
                            ?.setListener(object : Animator.AnimatorListener {
                                override fun onAnimationRepeat(animation: Animator?) {
                                }

                                override fun onAnimationEnd(animation: Animator?) {
                                    animating = false
                                }

                                override fun onAnimationCancel(animation: Animator?) {
                                }

                                override fun onAnimationStart(animation: Animator?) {
                                    animating = true
                                }

                            })
                } else {
                    imageView
                            ?.animate()
                            ?.translationX(0f)
                            ?.rotation(0f)
                            ?.scaleX(0f)
                            ?.scaleY(0f)
                            ?.alpha(0f)
                            ?.setDuration(2000)
                            ?.setListener(object : Animator.AnimatorListener {
                                override fun onAnimationRepeat(animation: Animator?) {
                                }

                                override fun onAnimationEnd(animation: Animator?) {
                                    animating = false
                                }

                                override fun onAnimationCancel(animation: Animator?) {
                                }

                                override fun onAnimationStart(animation: Animator?) {
                                    animating = true
                                }

                            })
                }
                animated = !animated
            }
        }
    }

}

