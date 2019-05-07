package com.kotlin.goodscenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.fragment.BaseMvpFragment
import com.kotlin.goodscenter.R
import com.kotlin.goodscenter.injection.component.DaggerCategoryComponent
import com.kotlin.goodscenter.injection.module.CategoryRepositoryModule
import com.kotlin.goodscenter.presenter.CategoryPresenter
import com.kotlin.goodscenter.presenter.view.CategoryView
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * @author : ${Zhang}
 * @Date   : 2019/5/1 10:32:32
 * @Des    :
 */
class CategoryFragment : BaseMvpFragment<CategoryPresenter>(), CategoryView {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_category, null)
    }


    /**
     *   这个生命周期是执行在视图加载完成以后的
     */
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ARouter.getInstance().inject(this)
        mLoginTv.onClick {
            ARouter.getInstance()
                .build("/UserCenter/Login")
                .navigation()
        }
    }

    override fun injectionComponent() {

        DaggerCategoryComponent
            .builder()
            .activityComponent(activityComponent)
            .categoryRepositoryModule(CategoryRepositoryModule())
            .build()
            .inject(this)

        mPresenter.mView = this
    }
}