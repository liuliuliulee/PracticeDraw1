package joy.liu.com.hencoderPractice.practice3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by joy on 2017/11/7.
 */
/**
 * 获取 textView 的矩阵宽度，已经包含矩阵中的 padding
 */
class Sample04MeasureTextView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint1: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val text1 = "Hello Joy!"
    val text2 = "最近如何!"
    val text3 = "工资涨了没有啊?"
    var measureText1: Float? = null
    var measureText2: Float? = null

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
        paint.textSize = 60f
        paint1.textSize = 80f
        measureText1 = paint.measureText(text1)
        measureText2 = paint1.measureText(text2)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawText(text1, 0f, 200f, paint)
        canvas.drawText(text2, 0f+(measureText1?:0f), 200f, paint1)
        canvas.drawText(text3, 0f+(measureText1?:0f)+(measureText2?:0f), 200f, paint)
    }
}