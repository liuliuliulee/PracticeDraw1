package joy.liu.com.hencoderPractice.practice6

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import joy.liu.com.hencoderPractice.UiUtils.dpToPixel


/**
 * Created by joy on 2017/11/16.
 */
class Sample08ObjectAnimatorView : View {
    val radius = dpToPixel(80f)

    var progress = 0f
        get() = field + 0f
        set(value) {
            Log.e("===>",value.toString())
            field = value
            invalidate()
        }


    var arcRectF = RectF()
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

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
        paint.textSize = dpToPixel(40f)
        paint.textAlign = Paint.Align.CENTER
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var centerX = width / 2
        var centerY = height / 2

        paint.color = Color.parseColor("#e91e63")
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = 15f
        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius)
        canvas.drawArc(arcRectF, 135f, progress * 2.7f, false, paint)

        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas.drawText((progress.toInt()).toString() + "%", centerX.toFloat(), centerY - (paint.ascent() + paint.descent()) / 2, paint)
    }

}

