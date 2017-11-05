package joy.liu.com.hencoderPractice.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import joy.liu.com.practicedraw1.R



/**
 * Created by joy on 2017/11/6.
 */
class Sample06LightingColorFilterView:View{
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap:Bitmap? = null
    var colorFilter1: ColorFilter = LightingColorFilter(0x00ffff, 0x000000)
    var colorFilter2: ColorFilter = LightingColorFilter(0xffffff, 0x003000)

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
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        paint.colorFilter=colorFilter1
        canvas.drawBitmap(bitmap,0f,0f,paint)
        paint.colorFilter=colorFilter2
        canvas.drawBitmap(bitmap,(bitmap?.width?:0+100).toFloat(),(bitmap?.height?:0+100).toFloat(),paint)

    }
}