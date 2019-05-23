package com.kotlin.base.widgets

import android.os.CountDownTimer

/**
 * @author : ${Zhang}
 * @Date : 2019/5/8 10:53:46
 * @Des :
 */
class MCountDownTimer
/**
 * @param millisInFuture    总共持续的时间
 * @param countDownInterval 倒计时的时间间隔
 */
    (millisInFuture: Long, countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {

    private var tickInterface: TickInterface? = null
    private var finishInterface: FinishInterface? = null


    fun setTickInterface(tickInterface: TickInterface) {
        this.tickInterface = tickInterface
    }

    fun setFinishInterface(finishInterface: FinishInterface) {
        this.finishInterface = finishInterface
    }

    /**
     * @param millisUntilFinished 还剩下的时间
     */
    override fun onTick(millisUntilFinished: Long) {
        //        sendCode.setText(millisUntilFinished / countDownInterval + "s");
        tickInterface!!.onTicks()
    }

    /**
     * 倒计时结束时候回调
     */
    override fun onFinish() {
        //倒计时结束让按钮可用
        //        sendCode.setEnabled(true);
        //        sendCode.setText("获取验证码");

        finishInterface!!.onFinish()
    }


    interface TickInterface {
        fun onTicks()
    }


    interface FinishInterface {
        fun onFinish()
    }

}
