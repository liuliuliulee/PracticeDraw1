package joy.liu.com.hencoderPractice.practice5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.util.Log

/**
 * Created by joy on 2017/11/14.
 */
class Sample05AfterOnDrawForegroundView : AppCompatImageView {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

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
        Log.e("==>","onDrawForeground5555")
    }


    override fun onDrawForeground(canvas: Canvas) {
        super.onDrawForeground(canvas)
        Log.e("==>","onDrawForeground5555")
        paint.color = Color.parseColor("#f44336")
        canvas.drawRect(0f, 40f, 200f, 120f, paint)
        paint.color = Color.WHITE
        canvas.drawText("New", 20f, 100f, paint)
    }

}