package joy.liu.com.hencoderPractice.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.R

/**
 * Created by joy on 2017/11/5.
 */
class Sample04BitmapShaderView : View {
    var paint: Paint = Paint()

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
        paint.isAntiAlias = true
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
        paint.shader = BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawCircle(600f, 600f, 500f, paint)
    }
}