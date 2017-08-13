package joy.liu.com.practicedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.UiUtils

/**
 * Created by joy on 2017/8/13.
 */
class DrawOvalView5:View {
    constructor(context: Context?):super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initData()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initData()
    }

    val paint = Paint()
    fun initData(){
        paint.apply {
            style= Paint.Style.FILL
            strokeWidth = UiUtils.dipToPx(context,20)*1.0f
            color = Color.RED
        }
    }

    override fun draw(canvas: Canvas) {
        canvas.translate(measuredWidth/2*1.0f,measuredHeight/2*1.0f)
        val rectF = RectF(UiUtils.dipToPx(context, -150) * 1.0f, UiUtils.dipToPx(context, -100) * 1.0f,
                UiUtils.dipToPx(context, 150) * 1.0f, UiUtils.dipToPx(context, 100) * 1.0f)
        canvas.drawOval(rectF,paint)
    }
}