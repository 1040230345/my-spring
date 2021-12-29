package cn.springframework.beans.factory.support;

import cn.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    <T>void registerBeanDefinition(String beanName, BeanDefinition<T> beanDefinition);
}
