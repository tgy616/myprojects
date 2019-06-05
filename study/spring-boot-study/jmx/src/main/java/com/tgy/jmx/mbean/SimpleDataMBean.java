package com.tgy.jmx.mbean;

/**
 * 简单数据 MBean
 * @author DragonSwimDiving
 * @program jmx
 * @Date 2019-06-04 17:30
 **/
public interface SimpleDataMBean {

    /**
     * Setter
     * Property
     * @param data
     */
    void setData(String data);

    /**
     * Getter
     * @return
     */
    String getData();
}
