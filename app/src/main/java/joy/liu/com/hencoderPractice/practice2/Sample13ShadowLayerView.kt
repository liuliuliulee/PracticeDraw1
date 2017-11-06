package joy.liu.com.hencoderPractice.practice2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by joy on 2017/11/6.
 */
/**
 * 图形下方阴影效果
 */
class Sample13ShadowLayerView: View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
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
        paint.setShadowLayer(10f,5f,5f, Color.RED)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        paint.textSize = 120f
        canvas.drawText("Joy Hello World!",50f,200f,paint)

    }
}