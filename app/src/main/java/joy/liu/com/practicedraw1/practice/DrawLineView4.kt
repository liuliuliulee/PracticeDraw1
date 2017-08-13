package joy.liu.com.practicedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.UiUtils

/**
 * Created by joy on 2017/8/13.
 */
class DrawLineView4:View {
    constructor(context:Context?):super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
//        Log.e("====>2", "constructor")
        initData()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
//        Log.e("====>3", "constructor")
        initData()
    }

    val paint = Paint()
    fun initData(){
        paint.apply {
            style=Paint.Style.FILL_AND_STROKE
            strokeWidth = UiUtils.dipToPx(context,20)*1.0f
            color = Color.CYAN
        }
    }

    override fun onDraw(canvas: Canvas) {
        canvas.translate(measuredWidth/2*1.0f,measuredHeight/2*1.0f)
        canvas.drawLine(UiUtils.dipToPx(context, -100) * 1.0f,UiUtils.dipToPx(context, -100) * 1.0f,
                UiUtils.dipToPx(context, 100) * 1.0f,UiUtils.dipToPx(context, 100) * 1.0f,paint)
    }
}