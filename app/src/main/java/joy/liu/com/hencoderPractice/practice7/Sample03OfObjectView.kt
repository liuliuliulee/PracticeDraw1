package joy.liu.com.hencoderPractice.practice7

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View


/**
 * Created by joy on 2017/11/16.
 */
class Sample03OfObjectView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var radius = 20f
    var position = PointF()
        set(value) {
            field = value
            invalidate()
        }


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
        paint.color = Color.parseColor("#009688")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val innerPaddingLeft = radius * 1
        val innterPaddingRight = radius * 1
        val innterPaddingTop = radius * 1
        val innterPaddingBottom = radius * 3
        val width = width - innerPaddingLeft - innterPaddingRight - radius * 2
        val height = height - innterPaddingTop - innterPaddingBottom - radius * 2

        canvas.drawCircle(innerPaddingLeft + radius + width/2 * position.x,
                innterPaddingTop + radius + height/2 * position.y,
                radius,
                paint)
    }

}