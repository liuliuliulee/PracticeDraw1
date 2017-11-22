package joy.liu.com.hencoderPractice.practice7

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import joy.liu.com.hencoderPractice.UiUtils.dpToPixel


/**
 * Created by joy on 2017/11/16.
 */
class Sample06KeyframeView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var radius = dpToPixel(80f)
    var progress = 0f
        set(value) {
            field = value
            invalidate()
        }
    var arcRect = RectF()



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
        paint.textSize=40f
        paint.textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var centerX = width/2
        var centerY = height/2
        paint.color = Color.parseColor("#E91E63")
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = dpToPixel(15f)
        arcRect.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius)
        canvas.drawArc(arcRect, 135f, progress * 2.7f, false, paint)

        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        canvas.drawText( progress.toInt().toString() + "%", centerX.toFloat(), centerY - (paint.ascent() + paint.descent()) / 2, paint)
    }

}