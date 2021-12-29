package cn.springframework.beans.factory.support;

import cn.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认单例bean注册
 * 2021年08月04日00:45:06
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public <T> T getSingleton(String beanName) {
        return (T) singletonObjects.get(beanName);
    }

    protected <T> void addSingleton(String beanName, T singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
