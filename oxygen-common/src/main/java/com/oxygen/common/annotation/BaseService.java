package com.oxygen.common.annotation;

import java.lang.annotation.*;

/**
 * 初始化继承BaseService的service
 * Created by yangxy on 2017/9/11.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseService {
}
