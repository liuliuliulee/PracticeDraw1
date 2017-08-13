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
class DrawPieChartView9:View {
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
        val rectF = RectF(UiUtils.dipToPx(context, -150) * 1.0f, UiUtils.dipToPx(context, -150) * 1.0f,
                UiUtils.dipToPx(context, 150) * 1.0f, UiUtils.dipToPx(context, 150) * 1.0f)
        canvas.drawArc(rectF,-45f,45f,true,paint)
        paint.color=Color.RED
        canvas.drawArc(rectF,10f,10f,true,paint)
        paint.color=Color.GRAY
        canvas.drawArc(rectF,25f,10f,true,paint)
        paint.color=Color.GREEN
        canvas.drawArc(rectF,40f,30f,true,paint)
        paint.color=Color.BLUE
        canvas.drawArc(rectF,80f,100f,true,paint)
        paint.color=Color.CYAN
        canvas.drawArc(rectF,-170f,110f,true,paint)
    }
}