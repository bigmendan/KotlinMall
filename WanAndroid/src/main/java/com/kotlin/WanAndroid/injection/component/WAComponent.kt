package com.kotlin.WanAndroid.injection.component

import com.kotlin.WanAndroid.injection.module.WAModule
import com.kotlin.WanAndroid.ui.fragment.HomeFragment
import com.kotlin.WanAndroid.ui.fragment.ProjectFragment
import com.kotlin.WanAndroid.ui.fragment.ProjectListFragment
import com.kotlin.WanAndroid.ui.fragment.SystemFragment
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.scope.PerComponentScope
import dagger.Component

@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = [WAModule::class])
interface WAComponent {

    fun inject(fragment: HomeFragment)

    fun inject(fragment: ProjectFragment)

    fun inject(fragment: ProjectListFragment)

    fun inject(fragment: SystemFragment)
}