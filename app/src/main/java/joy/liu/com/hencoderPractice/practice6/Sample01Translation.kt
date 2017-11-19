package joy.liu.com.hencoderPractice.practice6

import android.content.Context
import android.graphics.Outline
import android.graphics.Path
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import joy.liu.com.hencoderPractice.UiUtils.dpToPixel
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/16.
 */
class Sample01Translation : RelativeLayout {
    var animateBt: Button? = null
    var imageView: ImageView? = null
    var translationStateCount = if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) 6 else 4
    var translationState = 0

    constructor(context: Context) : super(context) {
        initData()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initData()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initData()
    }

    private fun initData() {

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animateBt = findViewById(R.id.animateBt)
        imageView = findViewById(R.id.imageView)
        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            //加阴影
            imageView?.outlineProvider = MusicOutlineProvider()
        }
        animateBt?.setOnClickListener { v ->
            when (translationState) {
                0 -> imageView?.animate()?.translationX(dpToPixel(100f))
                1 -> imageView?.animate()?.translationX(dpToPixel(0f))
                2 -> imageView?.animate()?.translationY(dpToPixel(50f))
                3 -> imageView?.animate()?.translationY(0f)
                4 -> if (SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    imageView?.animate()?.translationZ(dpToPixel(15f))
                5 -> if (SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    imageView?.animate()?.translationZ(0f)
            }
            translationState++
            if(translationState==translationStateCount)
                translationState=0
        }
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    inner class MusicOutlineProvider : ViewOutlineProvider() {
        var path: Path = Path()

        init {
            path.moveTo(0f, dpToPixel(10f))
            path.lineTo(dpToPixel(7f), dpToPixel(2f))
            path.lineTo(dpToPixel(116f), dpToPixel(58f))
            path.lineTo(dpToPixel(116f), dpToPixel(70f))
            path.lineTo(dpToPixel(7f), dpToPixel(128f))
            path.lineTo(dpToPixel(0f), dpToPixel(120f))
            path.close()
        }

        override fun getOutline(view: View?, outline: Outline?) {
            Log.e("===>", "getOutline")
            outline?.setConvexPath(path)
        }
    }
}