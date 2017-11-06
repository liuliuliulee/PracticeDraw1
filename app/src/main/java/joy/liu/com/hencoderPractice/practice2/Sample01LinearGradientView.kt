package joy.liu.com.hencoderPractice.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by joy on 2017/11/5.
 */
/**
 * 颜色渐变效果
 */
class Sample01LinearGradientView: View{

    var paint: Paint= Paint()
    //该代码块主构造函数的实体
    init {
    }

    constructor(context:Context):super(context){initData()}
    constructor(context: Context,attrs: AttributeSet):super(context,attrs){initData()}
    constructor(context: Context,attrs: AttributeSet,defStyleAttr:Int):super(context,attrs,defStyleAttr){initData()}

    private fun initData(){
        paint.isAntiAlias=true
        paint.shader = LinearGradient(100f,100f,500f,500f,
                Color.parseColor("#ffffff"),Color.parseColor("#000000"),Shader.TileMode.REPEAT)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawCircle(300f,300f,200f,paint)
    }
}