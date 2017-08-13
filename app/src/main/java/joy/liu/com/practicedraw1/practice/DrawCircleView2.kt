package joy.liu.com.practicedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.UiUtils

/**
 * Created by joy on 2017/7/23.
 */
class DrawCircleView2 : View {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
//        Log.e("====>2", "constructor")
        initData()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
//        Log.e("====>3", "constructor")
        initData()
    }

    var paint: Paint? = null
    var x1 = 0.0f
    var x2 = 0.0f
    var y1 = 0.0f
    var y2 = 0.0f

    fun initData() {
//        Log.e("====>", "initData")
        paint = Paint()
        paint?.apply {
            isAntiAlias = true
            color = Color.BLACK
        }

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //1
        paint?.style = Paint.Style.FILL_AND_STROKE
        canvas.drawCircle(x1, y1, UiUtils.dpToPx(resources, 60) * 1.0f, paint)
//        canvas.drawCircle(100.0f, 100.0f, 100.0f, Paint())
        paint?.apply {
            style = Paint.Style.STROKE
            color = Color.BLACK
        }
        canvas.drawCircle(x2, y1, UiUtils.dpToPx(resources, 60) * 1.0f, paint)
        paint?.apply {
            style = Paint.Style.FILL
            strokeWidth = 0f
            color = Color.BLUE
        }
        canvas.drawCircle(x1, y2, UiUtils.dpToPx(resources, 60) * 1.0f, paint)
        paint?.apply {
            style = Paint.Style.STROKE
            color = Color.BLACK
            strokeWidth = UiUtils.dpToPx(resources, 5) * 1.0f
        }
        canvas.drawCircle(x2, y2, UiUtils.dpToPx(resources, 60) * 1.0f, paint)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measuredWidth = measuredWidth
        val measuredHeight = measuredHeight
        x1 = measuredWidth / 4f
        x2 = measuredWidth * 3 / 4f
        y1 = measuredHeight / 6f
        y2 = measuredHeight * 3 / 6f
//        Log.e("===>", "" + measuredWidth + "," + measuredHeight + "," + x1 + "," + y1)
    }
}