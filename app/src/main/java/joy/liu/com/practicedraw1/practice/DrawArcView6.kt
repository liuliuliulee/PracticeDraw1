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
class DrawArcView6:View {
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
        canvas.drawArc(rectF,-110f,90f,true,paint)
        canvas.drawArc(rectF,40f,100f,false,paint)
        paint.apply {
            style=Paint.Style.STROKE
        }
        canvas.drawArc(rectF,-180f,60f,false,paint)
    }
}