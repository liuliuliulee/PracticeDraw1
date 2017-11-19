package joy.liu.com.hencoderPractice.practice5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet

/**
 * Created by joy on 2017/11/14.
 */
class Sample01AfterOnDrawView : AppCompatImageView {
    val DEBUG = true
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

    private fun initData() {
        paint.color = Color.parseColor("#FFC107")
        paint.textSize = 28f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if(DEBUG){
            if(drawable!=null){
                canvas.save()
                canvas.concat(imageMatrix)
                val bounds = drawable.bounds
//                尺寸：%1$d x %2$d
                canvas.drawText(String.format("尺寸：%s x %s",bounds.width(),bounds.height()),20f,40f,paint)
                canvas.restore()
            }
        }
    }
}