package joy.liu.com.hencoderPractice.practice6

import android.content.Context
import android.util.AttributeSet
import android.widget.*
import joy.liu.com.practicedraw1.R


/**
 * Created by joy on 2017/11/16.
 */
class Sample06Duration : LinearLayout {
    var animateBt: Button? = null
    var imageView: ImageView? = null
    var durationSb: SeekBar? = null
    var durationValueTv: TextView? = null
    var duration:Long= 300
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
        durationSb = findViewById(R.id.durationSb)
        durationValueTv = findViewById(R.id.durationValueTv)
        durationValueTv?.text = context.getString(R.string.ms_with_value, duration)
        durationSb?.max = 10
        durationSb?.progress = 1

        durationSb?.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                duration = (progress*300).toLong()
                durationValueTv?.text = context.getString(R.string.ms_with_value,duration)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        animateBt = findViewById(R.id.animateBt)
        imageView = findViewById(R.id.imageView)

        animateBt?.setOnClickListener { v ->
            when(translationState){
                0->imageView?.animate()?.translationX(100f)?.setDuration(duration)
                1->imageView?.animate()?.translationX(0f)?.setDuration(duration)
            }
            if(translationState<1){
                translationState++
            }else{
                translationState=0
            }
        }
    }

}

