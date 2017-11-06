package joy.liu.com.hencoderPractice.practice2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by joy on 2017/11/6.
 */
/**
 * 线头形状：平头、圆头、方头（线条宽度大于1才有效果）
 */
class Sample09StrokeCapView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {
        initData()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initData()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initData()
    }

    fun initData() {
        paint.strokeWidth = 40f
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        paint.strokeCap = Paint.Cap.BUTT
        canvas.drawLine(50f,50f,400f,50f,paint)

        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawLine(50f,150f,400f,150f,paint)

        paint.strokeCap = Paint.Cap.SQUARE
        canvas.drawLine(50f,250f,400f,250f,paint)
    }
}