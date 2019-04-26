package com.kotlin.base.widgets

import android.text.Editable
import android.text.TextWatcher

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/26 16:24:18
 * @Des    :  因为平时开发不会全部用到这几个方法，自定义一个 Watcher 默认实现，需要哪个就用哪个;
 */
open class DefaultWatcher : TextWatcher {

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }


    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }
}