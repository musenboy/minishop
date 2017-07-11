package com.musenboy.shop.base.ds;

/**
 * 数据源操作
 * @author Sam
 * @date 2017/7/11.
 */
public class DataSourceHolder {
    //线程本地环境
    //线程安全
    private static final ThreadLocal<String> ctxThread = new ThreadLocal<>();

    //设置数据源
    public static void setDataSource(String dataSource) {
        ctxThread.set(dataSource);
    }

    //获取数据源
    public static String getDataSource() {
        return ctxThread.get();
    }

    //清除数据源
    public static void clearDataSource() {
        ctxThread.remove();
    }
}
