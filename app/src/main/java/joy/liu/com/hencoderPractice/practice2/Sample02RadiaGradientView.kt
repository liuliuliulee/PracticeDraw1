package joy.liu.com.hencoderPractice.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by joy on 2017/11/5.
 */
class Sample02RadiaGradientView : View {
    var paint: Paint = Paint()

    constructor(context: Context):super(context){initData()}
    constructor(context: Context, attrs: AttributeSet):super(context,attrs){initData()}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr:Int):super(context,attrs,defStyleAttr){initData()}

    fun initData(){
        paint.isAntiAlias=true
        paint.shader = RadialGradient(300f,200f,200f,
                Color.parseColor("#e91e63"),Color.parseColor("#2196f3"),Shader.TileMode.REPEAT)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawCircle(500f,500f,400f,paint)
    }
}