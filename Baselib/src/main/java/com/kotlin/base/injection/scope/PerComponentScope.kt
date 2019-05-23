package com.kotlin.base.injection.scope

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME
/**
 * @author : ${Zhang}
 * @Date   : 2019/4/22 14:42:34
 * @Des    :
 */
@Scope
@Documented
@Retention(RUNTIME)
annotation class PerComponentScope