package com.snacks.common.interceptor;

import java.lang.annotation.*;

/**
 * Created by xuwushun on 2016/10/8.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LoginRequired {
}
