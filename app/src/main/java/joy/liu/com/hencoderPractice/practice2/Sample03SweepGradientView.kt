package joy.liu.com.hencoderPractice.practice2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.SweepGradient
import android.util.AttributeSet
import android.view.View

/**
 * Created by joy on 2017/11/5.
 */
class Sample03SweepGradientView : View {
    var paint: Paint = Paint()
    constructor(context: Context):super(context){initData()}
    constructor(context: Context, attrs: AttributeSet):super(context,attrs){initData()}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr:Int):super(context,attrs,defStyleAttr){initData()}

    fun initData(){
        paint.isAntiAlias=true
        paint.shader = SweepGradient(300f,300f,Color.parseColor("#e9e163"),Color.parseColor("#21936e"))
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawCircle(300f,300f,200f,paint)
    }
}