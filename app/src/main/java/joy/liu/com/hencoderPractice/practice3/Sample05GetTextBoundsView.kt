package joy.liu.com.hencoderPractice.practice3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.View



/**
 * Created by joy on 2017/11/7.
 */
/**
 * 利用 getTextBound 使文字居中显示
 */
class Sample05GetTextBoundsView:View {
    var paint1: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var texts = arrayOf("A", "a", "J", "j", "Â", "â")
    var yOffsets = arrayOf(0, 0, 0, 0, 0, 0)
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

        val textBounds = Rect()
        paint2.getTextBounds(texts[0], 0, texts[0].length, textBounds)
        Log.e("===>",textBounds.top.toString()+","+textBounds.bottom.toString()+","+textBounds.right+","+textBounds.left)
        yOffsets[0] = -(textBounds.top + textBounds.bottom) / 2
        paint2.getTextBounds(texts[1], 0, texts[1].length, textBounds)
        Log.e("===>",textBounds.top.toString()+","+textBounds.bottom.toString()+","+textBounds.right+","+textBounds.left)
        yOffsets[1] = -(textBounds.top + textBounds.bottom) / 2
        paint2.getTextBounds(texts[2], 0, texts[2].length, textBounds)
        yOffsets[2] = -(textBounds.top + textBounds.bottom) / 2
        paint2.getTextBounds(texts[3], 0, texts[3].length, textBounds)
        yOffsets[3] = -(textBounds.top + textBounds.bottom) / 2
        paint2.getTextBounds(texts[4], 0, texts[4].length, textBounds)
        yOffsets[4] = -(textBounds.top + textBounds.bottom) / 2
        paint2.getTextBounds(texts[5], 0, texts[5].length, textBounds)
        yOffsets[5] = -(textBounds.top + textBounds.bottom) / 2
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        canvas.drawRect(50f, topValue.toFloat(), (width - 50).toFloat(), bottomValue.toFloat(), paint1)
        canvas.drawRect(50f, topValue.toFloat()+400f, (width - 50).toFloat(), bottomValue.toFloat()+400f, paint1)
        val middle = (topValue + bottomValue) / 2
        val middle2 = (topValue + bottomValue+800f) / 2
        //y坐标为文字的 baseline
        //居中显示
        canvas.drawText(texts[0], 100f, (middle + yOffsets[0]).toFloat(), paint2)
        canvas.drawText(texts[1], 200f, (middle + yOffsets[1]).toFloat(), paint2)
        canvas.drawText(texts[2], 300f, (middle + yOffsets[2]).toFloat(), paint2)
        canvas.drawText(texts[3], 400f, (middle + yOffsets[3]).toFloat(), paint2)
        canvas.drawText(texts[4], 500f, (middle + yOffsets[4]).toFloat(), paint2)
        canvas.drawText(texts[5], 600f, (middle + yOffsets[5]).toFloat(), paint2)

        //不居中显示
        canvas.drawText(texts[0], 100f, (middle2 ).toFloat(), paint2)
        canvas.drawText(texts[1], 200f, (middle2 ).toFloat(), paint2)
        canvas.drawText(texts[2], 300f, (middle2 ).toFloat(), paint2)
        canvas.drawText(texts[3], 400f, (middle2 ).toFloat(), paint2)
        canvas.drawText(texts[4], 500f, (middle2 ).toFloat(), paint2)
        canvas.drawText(texts[5], 600f, (middle2 ).toFloat(), paint2)
    }
}