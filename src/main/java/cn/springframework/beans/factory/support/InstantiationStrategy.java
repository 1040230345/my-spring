package cn.springframework.beans.factory.support;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * bean实例方法
 */
public interface InstantiationStrategy {

    /**
     * bean实例方法
     * @param beanDefinition 自定义的bean定义
     * @param beanName bean名称
     * @param ctor 含着类信息的类
     * @param args 参数
     * @return
     * @throws BeansException
     */
    <T> T instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?>
            ctor, Object[] args) throws BeansException;
}
