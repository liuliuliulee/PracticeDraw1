package joy.liu.com.hencoderPractice.practice1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import joy.liu.com.hencoderPractice.UiUtils

/**
 * Created by joy on 2017/8/13.
 */
class DrawHistogramView8:View {
    constructor(context: Context?):super(context){
        initData()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initData()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initData()
    }

    val paint = Paint()
    fun initData(){
        paint.apply {
            isAntiAlias=true
            style= Paint.Style.FILL
            color = Color.BLACK
        }
    }

    override fun draw(canvas: Canvas) {
        canvas.translate(measuredWidth/2*1.0f,measuredHeight/2*1.0f)
        canvas.drawLine(0f,0f, UiUtils.dipToPx(context, 150) * 1.0f,0f,paint)
        canvas.drawLine(0f,0f, 0f, UiUtils.dipToPx(context, -150) * 1.0f,paint)

        val rectF1 = RectF(UiUtils.dipToPx(context, 10) * 1.0f, UiUtils.dipToPx(context, -20) * 1.0f,
                UiUtils.dipToPx(context, 35) * 1.0f, 0f)
        val rectF2 = RectF(UiUtils.dipToPx(context, 45) * 1.0f, UiUtils.dipToPx(context, -40) * 1.0f,
                UiUtils.dipToPx(context, 70) * 1.0f, 0f)
        val rectF3 = RectF(UiUtils.dipToPx(context, 80) * 1.0f, UiUtils.dipToPx(context, -80) * 1.0f,
                UiUtils.dipToPx(context, 105) * 1.0f, 0f)
        val rectF4 = RectF(UiUtils.dipToPx(context, 115) * 1.0f, UiUtils.dipToPx(context, -60) * 1.0f,
                UiUtils.dipToPx(context, 140) * 1.0f, 0f)
        paint.style=Paint.Style.FILL
        paint.color=Color.RED
        canvas.drawRect(rectF1,paint)
        canvas.drawRect(rectF2,paint)
        canvas.drawRect(rectF3,paint)
        canvas.drawRect(rectF4,paint)
    }
}