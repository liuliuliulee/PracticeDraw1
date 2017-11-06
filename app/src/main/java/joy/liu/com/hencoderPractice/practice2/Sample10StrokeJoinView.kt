package joy.liu.com.hencoderPractice.practice2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * Created by joy on 2017/11/6.
 */
/**
 * 线条拐角形状
 */
class Sample10StrokeJoinView:View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path = Path()

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
        paint.style=Paint.Style.STROKE

        path.rLineTo(200f,0f)
        path.rLineTo(-160f,120f)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        canvas.save()

        canvas.translate(100f,100f)
        paint.strokeJoin = Paint.Join.MITER//尖头默认
        canvas.drawPath(path,paint)

        canvas.translate(300f,0f)
        paint.strokeJoin = Paint.Join.BEVEL//平头
        canvas.drawPath(path,paint)

        canvas.translate(300f,0f)
        paint.strokeJoin=Paint.Join.ROUND//圆角
        canvas.drawPath(path,paint)

        canvas.restore()


    }
}