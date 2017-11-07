package joy.liu.com.hencoderPractice.practice3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * Created by joy on 2017/11/7.
 */
class Sample06GetFontMetricsView : View {
    var paint1: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var texts = arrayOf("A", "a", "J", "j", "Â", "â")
    var yOffsets: Float? = null
    var topValue = 200
    var bottomValue = 400

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
        paint1.style = Paint.Style.STROKE
        paint1.strokeWidth = 20f
        paint1.color = Color.parseColor("#E91E63")
        paint2.textSize = 160f

        val fontMetrics = paint2.fontMetrics
        Log.e("=======>", fontMetrics.ascent.toString() + "," + fontMetrics.descent)
        yOffsets = -(fontMetrics.ascent + fontMetrics.descent) / 2

    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawRect(50f, topValue.toFloat(), (width - 50).toFloat(), bottomValue.toFloat(), paint1)

        var middle = (topValue + bottomValue) / 2
        canvas.drawText(texts[0], 100f, middle + (yOffsets ?: 0f), paint2)
        canvas.drawText(texts[1], 200f, middle + (yOffsets ?: 0f), paint2)
        canvas.drawText(texts[2], 300f, middle + (yOffsets ?: 0f), paint2)
        canvas.drawText(texts[3], 400f, middle + (yOffsets ?: 0f), paint2)
        canvas.drawText(texts[4], 500f, middle + (yOffsets ?: 0f), paint2)
        canvas.drawText(texts[5], 600f, middle + (yOffsets ?: 0f), paint2)
    }

}