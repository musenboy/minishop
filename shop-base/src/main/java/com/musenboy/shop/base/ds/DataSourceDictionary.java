package com.musenboy.shop.base.ds;

/**
 * 多数据源枚举
 * 实现分布式数据库
 * 可配置多个数据库
 * @author Sam
 * @date 2017/7/11.
 */
public class DataSourceDictionary {

    //主库
    public static final String MASTER = "masterDataSource";

    //从库
    public static final String slave = "slaveDataSource";
}
