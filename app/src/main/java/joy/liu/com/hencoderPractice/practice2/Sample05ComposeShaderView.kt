package joy.liu.com.hencoderPractice.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.R

/**
 * Created by joy on 2017/11/5.
 */
class Sample05ComposeShaderView:View{
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
        setLayerType(LAYER_TYPE_SOFTWARE,null)//硬件加速下 ComposeShader 不能使用两个同类型的 Shader
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
        val bitmapLogo = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
        val bitmapShader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val bitmapShaderLogo = BitmapShader(bitmapLogo, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val composeShader = ComposeShader(bitmapShader, bitmapShaderLogo, PorterDuff.Mode.DST_IN)
        paint.shader = composeShader
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawCircle(400f,400f,400f,paint)
    }
}