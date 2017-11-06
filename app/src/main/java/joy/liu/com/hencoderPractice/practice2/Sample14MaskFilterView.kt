package joy.liu.com.hencoderPractice.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/6.
 */
class Sample14MaskFilterView : View {
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var maskFilter1: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
    var maskFilter2: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
    var maskFilter3: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
    var maskFilter4: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)
    var bitmap: Bitmap? = null

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
        setLayerType(LAYER_TYPE_SOFTWARE, null)//使用软件加速
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        val left = ((bitmap?.width ?: 0) + 200).toFloat()
        val top = ((bitmap?.height ?: 0) + 200).toFloat()

        paint.maskFilter=maskFilter1
        canvas.drawBitmap(bitmap,100f,100f,paint)

        paint.maskFilter=maskFilter2
        canvas.drawBitmap(bitmap,left,100f,paint)

        paint.maskFilter=maskFilter3
        canvas.drawBitmap(bitmap,100f,top,paint)

        paint.maskFilter=maskFilter4
        canvas.drawBitmap(bitmap,left,top,paint)


    }

}