package joy.liu.com.hencoderPractice.practice3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by joy on 2017/11/7.
 */
class Sample01DrawTextView : View {

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
        canvas.drawText(text,200f,200f,paint)
    }
}