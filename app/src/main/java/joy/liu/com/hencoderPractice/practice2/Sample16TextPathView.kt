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
 * 获取textPath
 */
class Sample16TextPathView:View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var pathPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPath = Path()
    var text = "Hello Joy"

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
        setLayerType(LAYER_TYPE_SOFTWARE,null)
        paint.textSize = 140f
        paint.getTextPath(text, 0, text.length, 50f, 400f, textPath)

        pathPaint.style = Paint.Style.STROKE
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        canvas.drawText(text, 50f, 200f, paint)

        canvas.drawPath(textPath, pathPaint)
    }
}