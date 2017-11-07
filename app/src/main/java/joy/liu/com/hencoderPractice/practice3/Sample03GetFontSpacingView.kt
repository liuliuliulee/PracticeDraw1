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
 * getFontSpacing 获取两行文字 baseline 最佳距离
 */
class Sample03GetFontSpacingView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val text = "Hello Joy"

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
        paint.textSize = 120f
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        val fontSpacing = paint.fontSpacing
        canvas.drawText(text, 50f, 100f, paint)
        canvas.drawText(text, 50f, 100f + fontSpacing, paint)
        canvas.drawText(text, 50f, 100f + fontSpacing * 2, paint)
    }
}