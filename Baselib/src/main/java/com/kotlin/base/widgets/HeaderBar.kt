package com.kotlin.base.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.kotlin.base.R
import kotlinx.android.synthetic.main.layout_header_bar.view.*

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/15 17:26:11
 * @Des    :  自定义 顶部栏;
 */
class HeaderBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var isShowBack = true
    private var titleText: String? = null
    private var rightText: String? = null
    private var titleTextSize: Float = 0f
    private var rightTextSize: Float = 0f

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar)
        isShowBack = typedArray.getBoolean(R.styleable.HeaderBar_isShowBack, true)
        titleText = typedArray.getString(R.styleable.HeaderBar_titleText)
        rightText = typedArray.getString(R.styleable.HeaderBar_rightText)

        // 设置字体不管用 ;
//        titleTextSize = typedArray.getDimension(R.styleable.HeaderBar_titleTextSize, 18f)
//        rightTextSize = typedArray.getDimension(R.styleable.HeaderBar_rightTextSize, 14f)


        initView()
        typedArray.recycle()

    }

    private fun initView() {
        View.inflate(context, R.layout.layout_header_bar, this)
        mLeftIv.visibility = if (isShowBack) View.VISIBLE else View.GONE

        // 如果 titleText 不为空，就会执行后面的方法，并且把titleText 作为参数放在方法里
        titleText.let {
            mTitleTv.text = it   // it  在这里就相当于  titlieText

//            mTitleTv.textSize = titleTextSize
        }

        rightText.let {
            mRightTv.text = it

            mRightTv.visibility = View.VISIBLE

//            mRightTv.textSize = rightTextSize
        }


    }
}