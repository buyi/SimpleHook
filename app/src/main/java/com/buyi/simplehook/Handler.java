package com.buyi.simplehook;

/**
 * Created by buyi on 16/8/10.
 */
public interface Handler
{
    /**
     * 在原方法执行之前执行
     * @param params 原方法参数
     */
    public void before(Object instance, Object[] params);
}