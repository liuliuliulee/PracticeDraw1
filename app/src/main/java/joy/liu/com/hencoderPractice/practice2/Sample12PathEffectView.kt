package joy.liu.com.hencoderPractice.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


/**
 * Created by joy on 2017/11/6.
 */
class Sample12PathEffectView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path = Path()
    //线条拐角变圆角
    var cornerPathEffect: PathEffect = CornerPathEffect(20f)
    //线条随机偏离，segmentLength 是用来拼接的每个线段的长度， deviation 是偏离量
    var discretePathEffect: PathEffect = DiscretePathEffect(20f, 5f)
    //intervals 数组指定虚线的格式 如 [2,4,3,5] 即画线2，空白4，画线3，空白5 然后循环此格式画线，phase 虚线的偏移量
    var dashPathEffect: PathEffect = DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 0f)
    //使用一个 path 来绘制虚线
    var pathDashPathEffect: PathEffect? = null
    //先画一个，再画一个，形成叠加效果
    var sumPathEffect: PathEffect = SumPathEffect(dashPathEffect, discretePathEffect)
    //两个 pathEffect 先结合在一起，再绘制出来，形成结合效果
    var composePathEffect: PathEffect = ComposePathEffect(dashPathEffect, discretePathEffect)

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
        paint.style = Paint.Style.STROKE
        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(80f, -150f)
        path.rLineTo(100f,100f)
        path.rLineTo(70f,-120f)
        path.rLineTo(150f,80f)

        var dashPath = Path()
        dashPath.lineTo(20f,-30f)
        dashPath.lineTo(40f,0f)
        dashPath.close()
        //dashPath 虚线的形状，advance 两个 shape 起点的间隔，phase 虚线的偏移量，
        //style 指定拐弯改变的时候 shape 的转换方式，有三种：TRANSLATE(位移)、ROTATE(旋转)、MORPH(变体)
        pathDashPathEffect = PathDashPathEffect(dashPath,50f,0f,PathDashPathEffect.Style.ROTATE)

    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        paint.pathEffect = cornerPathEffect
        canvas.drawPath(path,paint)

        canvas.save()
        canvas.translate(500f,0f)
        paint.pathEffect = discretePathEffect
        canvas.drawPath(path,paint)
        canvas.restore()


        canvas.save()
        canvas.translate(0f,200f)
        paint.pathEffect = dashPathEffect
        canvas.drawPath(path,paint)
        canvas.restore()


        canvas.save()
        canvas.translate(500f,200f)
        paint.pathEffect = pathDashPathEffect
        canvas.drawPath(path,paint)
        canvas.restore()


        canvas.save()
        canvas.translate(0f,400f)
        paint.pathEffect = sumPathEffect
        canvas.drawPath(path,paint)
        canvas.restore()


        canvas.save()
        canvas.translate(500f,400f)
        paint.pathEffect = composePathEffect
        canvas.drawPath(path,paint)
        canvas.restore()

        paint.pathEffect=null


    }
}