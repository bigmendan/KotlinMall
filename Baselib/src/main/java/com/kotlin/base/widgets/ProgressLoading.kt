package com.kotlin.base.widgets

import android.app.Dialog
import android.content.Context

import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import com.kotlin.base.R
import org.jetbrains.anko.find

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/18 16:41:52
 * @Des    : 继承自 Dialog ；
 */
class ProgressLoading private constructor(context: Context, themeResId: Int) : Dialog(context, themeResId) {


    companion object {
        private lateinit var mDialog: ProgressLoading
        // 动画
        private var animDrawable: AnimationDrawable? = null

        fun create(context: Context): ProgressLoading {
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)

            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)   // 点击外部是否可以取消
            mDialog.window.attributes.gravity = Gravity.CENTER

            val lp = mDialog.window.attributes
            lp.dimAmount = 0.2f                     // 灰度？

            mDialog.window.attributes = lp

            val loadingView = mDialog.find<ImageView>(R.id.iv_loading)
            animDrawable = loadingView.background as AnimationDrawable


            return mDialog
        }


    }

    fun showLoading() {
        super.show()   // 调用  dialog  的show()
        animDrawable?.start()
    }

    fun hideLoading() {
        super.dismiss()
        animDrawable?.stop()
    }

}