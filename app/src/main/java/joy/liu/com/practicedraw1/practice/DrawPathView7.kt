package joy.liu.com.practicedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.UiUtils

/**
 * Created by joy on 2017/8/13.
 */
class DrawPathView7:View {
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
            style= Paint.Style.STROKE
            color = Color.BLACK
        }
    }


    override fun draw(canvas: Canvas) {
        canvas.translate(measuredWidth/2*1.0f,measuredHeight/2*1.0f)
        val path = Path()
//        path.addCircle(0f,0f, UiUtils.dipToPx(context, 100) * 1.0f,Path.Direction.CCW)
//        path.lineTo(UiUtils.dipToPx(context, -100) * 1.0f,UiUtils.dipToPx(context, -100) * 1.0f)
//        path.lineTo(UiUtils.dipToPx(context, -100) * 1.0f,UiUtils.dipToPx(context, 100) * 1.0f)
//        path.close()
//        canvas.drawPath(path,paint)
        path.moveTo(UiUtils.dipToPx(context, -100) * 1.0f, 0f)
        path.quadTo(UiUtils.dipToPx(context, -100) * 1.0f,UiUtils.dipToPx(context, -100) * 1.0f,
                0f,UiUtils.dipToPx(context, -100) * 1.0f)
        path.quadTo(UiUtils.dipToPx(context, 100) * 1.0f,UiUtils.dipToPx(context, -100) * 1.0f,
                UiUtils.dipToPx(context, 100) * 1.0f,0f)
        path.quadTo(UiUtils.dipToPx(context, 100) * 1.0f,UiUtils.dipToPx(context, 100) * 1.0f,
                0f,UiUtils.dipToPx(context, 100) * 1.0f)
        path.quadTo(UiUtils.dipToPx(context, -100) * 1.0f,UiUtils.dipToPx(context, 100) * 1.0f,
                UiUtils.dipToPx(context, -100) * 1.0f,0f)
        canvas.drawPath(path,paint)
    }
}