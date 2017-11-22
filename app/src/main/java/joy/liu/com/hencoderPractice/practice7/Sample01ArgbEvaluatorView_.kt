package joy.liu.com.hencoderPractice.practice7

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View




/**
 * Created by joy on 2017/11/16.
 */
class Sample01ArgbEvaluatorView_ : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var color: Int = 0xff0000
        set(value) {
            field = value
            invalidate()
        }


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

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color= Color.parseColor(color.toString())
        canvas.drawCircle(width/2.toFloat(),height/2.toFloat(),width/6.toFloat(),paint)
    }

}