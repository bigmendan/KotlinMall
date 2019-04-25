package com.kotlin.UserCenter.ui.activity

import android.os.Bundle
import android.view.View
import com.kotlin.UserCenter.Injection.component.DaggerRepositoryComponent

import com.kotlin.UserCenter.Injection.module.UserRepositoryModule
import com.kotlin.UserCenter.R
import com.kotlin.UserCenter.presenter.RegisterPresenter
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.base.ui.activity.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

/**
 *  引入 Dagger2 的作用是为了给应用的各部分解耦
 *    如果一个功能需要实例化另外一个对象来完成，这就是耦合， Dagger2 的引入就是为了解除这种耦合
 *
 *     目前所有的 Activity 中都需要去执行这一步 有时候忘了怎么办 ，在 BaseActivity中将这个
 *     过程去封装一个抽象方法 ;
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {


    // 注册   在Activity 中 具体实现 RegisterView 中的方法 ;
    override fun onRegisterResult(result: Boolean) {

        toast("注册成功")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // 直接使用控件ID 进行事件监听
        register.setOnClickListener(View.OnClickListener {
            mPresenter.register2("我是赵文杰爸爸3", "123212", "123212")

        })

    }

    override fun injectionComponent() {

        DaggerRepositoryComponent.builder().activityComponent(activityComponent)
            .userRepositoryModule(UserRepositoryModule()).build().inject(this)
        // mPresenter 已经在BaseMvpActivity 中被声明 ;
        mPresenter.mView = this

    }

    /**
     *  将这个方法在 BaseActivity 中 抽象化了 不会玩了 inject()
     */
    private fun initInjection() {
        /**    因为BaseMvpActivity 中传入的 是一个泛型，需要实例化 ;
         *     mPresenter = RegisterPresenter()    // 目前是 通过实例化的方法，引入Dagger2 可以直接 使用这个对象
         *     presenter 中的 View 引用 赋值;
         *     mPresenter.mView = this
         */


        // mPresenter 已经在BaseMvpActivity 中被声明 ;
        mPresenter.mView = this
    }


}
