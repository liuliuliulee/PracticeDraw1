package joy.liu.com.hencoderPractice.practice4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

/**
 * Created by joy on 2017/11/8.
 */
class CanvasScaleView : View {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        var paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.parseColor("#8ef123")
        paint.style=Paint.Style.STROKE
        paint.strokeWidth=10f
        canvas.translate(width / 2.toFloat(), height / 2.toFloat())

        var rect = Rect(0, -400, 400, 0)
        canvas.drawRect(rect, paint)
        canvas.scale(-0.5f, 0.5f, 200f, 0f)
        canvas.drawRect(rect, paint)

    }
}