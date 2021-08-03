package cn.springframework;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 创建bean工厂
 * jackson
 * 2021年08月03日23:51:54
 */
public class BeanFactory {

    //使用线程安全的ConcurrentHashMap
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap =
            new ConcurrentHashMap<String,BeanDefinition>();


    //获取bean
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    //注册bean
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
