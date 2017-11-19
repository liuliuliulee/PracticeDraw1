package joy.liu.com.hencoderPractice.practice5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.LinearLayout


/**
 * Created by joy on 2017/11/14.
 */
class Sample04DispatchDrawLayout : LinearLayout {

    var pattern = Pattern()

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
//        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        pattern.draw(canvas)
    }

    companion object {
        private val PATTERN_RATIO = 5f / 6
    }

    inner class Pattern {

        private var patternPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        private var spots: Array<Spot?>
        init {
            spots = arrayOfNulls(4)
            spots[0] = Spot(0.24f, 0.3f, 0.026f)
            spots[1] = Spot(0.69f, 0.25f, 0.067f)
            spots[2] = Spot(0.32f, 0.6f, 0.067f)
            spots[3] = Spot(0.62f, 0.78f, 0.083f)
        }

        init {
            patternPaint.color = Color.parseColor("#A0E91E63")
        }

        fun draw(canvas: Canvas) {
            val repitition = Math.ceil((width.toFloat() / height).toDouble()).toInt()
            for (i in 0 until spots.size * repitition) {
                val spot = spots[i % spots.size]
                canvas.drawCircle((i / spots.size).toFloat() * height.toFloat() * PATTERN_RATIO + (spot?.relativeX ?: 0f) * height, (spot?.relativeY ?: 0f) * height, (spot?.relativeSize ?: 0f) * height, patternPaint)
            }
        }


        inner class Spot(val relativeX: Float, val relativeY: Float, val relativeSize: Float)
    }
}