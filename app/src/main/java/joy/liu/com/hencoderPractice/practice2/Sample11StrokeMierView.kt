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
class Sample11StrokeMierView:View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path = Path()

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
        paint.strokeWidth = 20f
        paint.style= Paint.Style.STROKE

        path.rLineTo(200f,0f)
        path.rLineTo(-160f,120f)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        canvas.save()

        canvas.translate(100f,100f)
        paint.strokeMiter=1f
        canvas.drawPath(path,paint)

        canvas.translate(300f,0f)
        paint.strokeMiter=3f
        canvas.drawPath(path,paint)

        canvas.translate(300f,0f)
        paint.strokeMiter=5f
        canvas.drawPath(path,paint)

        canvas.restore()


    }
}