package com.kotlin.goodscenter.injection.component

import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.scope.ActivityScope
import com.kotlin.base.injection.scope.PerComponentScope
import com.kotlin.goodscenter.injection.module.CategoryRepositoryModule
import com.kotlin.goodscenter.ui.activity.CategoryActivity
import com.kotlin.goodscenter.ui.fragment.CategoryFragment
import dagger.Component

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/30 17:18:13
 * @Des    :
 */
@PerComponentScope
@Component(
    dependencies = [ActivityComponent::class],
    modules = [CategoryRepositoryModule::class]
)
interface CategoryComponent {

    fun inject(fragment: CategoryFragment)

}