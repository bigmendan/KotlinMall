package com.kotlin.goodscenter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.view.menu.MenuView
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.goodscenter.R
import com.kotlin.goodscenter.injection.component.DaggerCategoryComponent
import com.kotlin.goodscenter.injection.module.CategoryRepositoryModule
import com.kotlin.goodscenter.presenter.CategoryPresenter
import com.kotlin.goodscenter.presenter.view.CategoryView
import javax.inject.Inject


/**
 *  分类 Activity
 */
class CategoryActivity : BaseMvpActivity<CategoryPresenter>(), CategoryView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
    }


    override fun injectionComponent() {

    }


}
