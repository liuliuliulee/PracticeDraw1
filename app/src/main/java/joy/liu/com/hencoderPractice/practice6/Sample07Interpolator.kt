package joy.liu.com.hencoderPractice.practice6

import android.content.Context
import android.graphics.Path
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.support.v4.view.animation.PathInterpolatorCompat
import android.util.AttributeSet
import android.view.animation.*
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Spinner
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/16.
 */
class Sample07Interpolator : LinearLayout {
    var animateBt: Button? = null
    var imageView: ImageView? = null
    var spinner: Spinner? = null
    var interpolators = arrayOfNulls<Interpolator>(13)
    var interpolatorPath: Path? = null

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
        interpolatorPath = Path()
        interpolatorPath?.lineTo(0.25f, 0.25f)
        interpolatorPath?.moveTo(0.25f, 1.5f)
        interpolatorPath?.lineTo(1f, 1f)

        interpolators[0] = AccelerateDecelerateInterpolator()
        interpolators[1] = LinearInterpolator()
        interpolators[2] = AccelerateInterpolator()
        interpolators[3] = DecelerateInterpolator()
        interpolators[4] = AnticipateInterpolator()
        interpolators[5] = OvershootInterpolator()
        interpolators[6] = AnticipateOvershootInterpolator()
        interpolators[7] = BounceInterpolator()
        interpolators[8] = CycleInterpolator(0.5f)
        interpolators[9] = PathInterpolatorCompat.create(interpolatorPath)
        interpolators[10] = FastOutLinearInInterpolator()
        interpolators[11] = FastOutSlowInInterpolator()
        interpolators[12] = LinearOutSlowInInterpolator()

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        spinner = findViewById(R.id.interpolatorSpinner)
        animateBt = findViewById(R.id.animateBt)
        imageView = findViewById(R.id.imageView)

        animateBt?.setOnClickListener { v ->
            imageView
                    ?.animate()
                    ?.translationY(500f)
                    ?.setDuration(2000)
                    ?.setInterpolator(interpolators[(spinner?.selectedItemPosition) ?: 0])
                    ?.withEndAction({
                        imageView?.postDelayed({ imageView?.translationY = 0f }, 500)
                    })
        }
    }

}

