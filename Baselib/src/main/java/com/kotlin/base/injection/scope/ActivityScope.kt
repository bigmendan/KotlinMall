package com.kotlin.base.injection.scope

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME
/**
 * @author : ${Zhang}
 * @Date   : 2019/4/22 14:42:34
 * @Des    :  自定义 Scope ， 当 ActivityComponent 依赖 AppComponent 时 ，因为 AppComponent 中有作用域，
 */
@Scope
@Documented
@Retention(RUNTIME)
annotation class ActivityScope