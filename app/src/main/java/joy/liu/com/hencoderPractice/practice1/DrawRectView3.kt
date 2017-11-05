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
class DrawRectView3:View {

    constructor(context:Context?):super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
//        Log.e("====>2", "constructor")
        initData()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
//        Log.e("====>3", "constructor")
        initData()
    }

    var paint: Paint? = null
//    var mWidth=0
//    var mHeight=0
    fun initData(){
        paint = Paint()
        paint?.apply {
            isAntiAlias = true
            color = Color.RED
            style = Paint.Style.FILL

        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        mWidth = measuredWidth
//        mHeight = measuredHeight
    }

    override fun onDraw(canvas: Canvas) {
        canvas.translate(measuredWidth/2*1.0f,measuredHeight/2*1.0f)
        val rectF = RectF(UiUtils.dipToPx(context, -100) * 1.0f, UiUtils.dipToPx(context, -100) * 1.0f, 0f, 0f)
        canvas.drawRect(rectF,paint)
        val roundRectF = RectF(UiUtils.dipToPx(context, 0) * 1.0f, UiUtils.dipToPx(context, 0) * 1.0f,
                UiUtils.dipToPx(context, 100) * 1.0f, UiUtils.dipToPx(context, 100) * 1.0f)
        canvas.drawRoundRect(roundRectF, UiUtils.dipToPx(context, 10) * 1.0f, UiUtils.dipToPx(context, 10) * 1.0f,paint)
    }
}