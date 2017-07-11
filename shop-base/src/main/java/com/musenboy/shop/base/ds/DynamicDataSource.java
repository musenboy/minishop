package com.musenboy.shop.base.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 获取数据源
 * @author Sam
 * @date 2017/7/11.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private final static Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

    //线程本地环境
    //线程安全
    private static final ThreadLocal<String> ctxThread = new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = getDataSource();
        log.info("当前的数据源是：｛｝", dataSource);
        return dataSource;
    }

    //设置数据源
    public static void setDataSource(String dataSource) {
        ctxThread.set(dataSource);
    }

    //获取数据源
    public static String getDataSource() {
        String dataSource = ctxThread.get();
        if (null == dataSource) {
            DynamicDataSource.setDataSource(DataSourceDictionary.MASTER);
        }
        return ctxThread.get();
    }

    //清除数据源
    public static void clearDataSource() {
        ctxThread.remove();
    }
}
