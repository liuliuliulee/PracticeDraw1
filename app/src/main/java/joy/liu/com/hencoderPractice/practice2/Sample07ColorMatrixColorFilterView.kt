package joy.liu.com.hencoderPractice.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.R

/**
 * Created by joy on 2017/11/6.
 */
/**
 * 颜色矩阵变换
 */
class Sample07ColorMatrixColorFilterView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap:Bitmap? = null
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
        bitmap =BitmapFactory.decodeResource(resources, R.drawable.batman)
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(0f)//饱和度为0
        //矩阵颜色过滤器
        val colorMatrixColorFilter = ColorMatrixColorFilter(colorMatrix)
        paint.colorFilter = colorMatrixColorFilter
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawBitmap(bitmap,0f,0f,paint)
    }

}