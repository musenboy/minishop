package com.musenboy.shop.base.ds;

import java.lang.annotation.*;

/**
 * 数据源注解
 * 用法：
 *      加在方法、实现类、接口上
 * 格式：
 *      @DataSource(name = "库名")
 *      其中name如果为空，则默认为MASTER库
 * @author Sam
 * @date 2017/7/11.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default DataSourceDictionary.MASTER;
}