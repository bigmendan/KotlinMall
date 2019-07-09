package com.kotlin.base.ui.fragment


import androidx.fragment.app.Fragment
import com.trello.rxlifecycle3.components.RxFragment

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/23 11:13:51
 * @Des    : BaseFragment
 */
open class BaseFragment : Fragment() {


    /*
        视图是否加载完成
     */
    private var isViewPrepare = false


    /*
       数据是否加载过了
     */
    private var hasLoadData = false





}