package com.kotlin.WanAndroid.utils

import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.provider.common.ProviderConstant
import android.text.TextUtils
import com.kotlin.base.ext.loge


/**
 *  把 历史搜索记录通过字符串 + ， 保存在SharedPreferences 中
 */
class HistoryUtil {

    companion object {

        fun putHistory(value: String) {

            if (TextUtils.isEmpty(value)) {
                return
            }

            //获取之前保存的历史记录
            val longHistory = AppPrefsUtils.getString(ProviderConstant.SEARCH_HISTORY)

            //逗号截取 保存在数组中
            val tmpHistory = longHistory.split(",".toRegex())
                .dropLastWhile { it.isEmpty() }
                .toTypedArray()

            //将改数组转换成ArrayList
            val historyList = tmpHistory.asList() as MutableList
//            loge("存储=== 初始读取搜索历史列表 = $historyList")

            if (historyList.isNotEmpty()) {
                //1.移除之前重复添加的元素
                for (i in historyList.indices) {
                    if (value == historyList[i]) {
                        historyList.removeAt(i)
                        break
                    }
                }

                //2.将新输入的文字添加集合的第0位也就是最前面
                historyList.add(0, value)
//                loge("历史记录的 size = ${historyList.size}")
                if (historyList.size > 8) {
                    //3.最多保存8条搜索记录 删除最早搜索的那一项
                    historyList.removeAt(historyList.size - 1)
                }
                //逗号拼接
                val sb = StringBuilder()
                for (i in historyList.indices) {
                    sb.append(historyList[i] + ",")
                }
//                loge("存储 ==  如果是多条数据，打印数据$sb")
                //保存到sp
                AppPrefsUtils.putString(ProviderConstant.SEARCH_HISTORY, sb.toString())
            } else {
                //之前未添加过
                AppPrefsUtils.putString(ProviderConstant.SEARCH_HISTORY, "$value,")


            }


        }


        fun getHistory(): MutableList<String> {
            val longHistory = AppPrefsUtils.getString(ProviderConstant.SEARCH_HISTORY)

            //split后长度为1有一个空串对象
            val tmpHistory =
                longHistory!!
                    .split(",".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()
            val historyList = tmpHistory.asList() as MutableList

//            loge("读取 ==   历史记录= $historyList")

            //如果没有搜索记录，split之后第0位是个空串的情况下
            if (historyList.size == 1 && historyList[0] == "") {
                //清空集合，这个很关键
                historyList.clear()
            }
            return historyList
        }



    }
}