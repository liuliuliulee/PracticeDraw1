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
 * 图像叠加效果
 */
class Sample08XfermodeView:View{
    var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap1: Bitmap? = null
    var bitmap2: Bitmap? = null
    private var xfermode1: Xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
    private var xfermode2: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    private var xfermode3: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)

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
        bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        //使用离屏缓冲
        val saveLayer = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)
//        val save = canvas.save()

        canvas.drawBitmap(bitmap1, 0f, 0f, paint)//dst
        paint.xfermode = xfermode1
        canvas.drawBitmap(bitmap2, 0f, 0f, paint)//src
        paint.xfermode = null

        canvas.drawBitmap(bitmap1,(bitmap1?.width?:0+100).toFloat(),0f,paint)
        paint.xfermode=xfermode2
        canvas.drawBitmap(bitmap2,(bitmap1?.width?:0+100).toFloat(),0f,paint)
        paint.xfermode=null

        canvas.drawBitmap(bitmap1,0f,(bitmap1?.height?:0+100).toFloat(),paint)
        paint.xfermode=xfermode3
        canvas.drawBitmap(bitmap2,0f,(bitmap1?.height?:0+100).toFloat(),paint)
        paint.xfermode=null

        //把离屏缓冲数据画到 canvas
        canvas.restoreToCount(saveLayer)
    }
}