package joy.liu.com.hencoderPractice.practice3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

/**
 * Created by joy on 2017/11/7.
 */
/**
 * staticLayout 自动换行和遇见\n会自动换行
 */
class Sample02StaticLayoutView: View {
    var paint: TextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    val text = "Hello \nJoy Hello Joy Hello Joy Hello Joy"
    var staticLayout:StaticLayout? = null

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
        staticLayout = StaticLayout(text,paint,500, Layout.Alignment.ALIGN_NORMAL,1f,0f,true)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.save()
        canvas.translate(50f,40f)
        staticLayout?.draw(canvas)
        canvas.restore()
    }
}