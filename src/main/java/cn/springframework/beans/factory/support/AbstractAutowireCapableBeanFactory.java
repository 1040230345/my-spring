package cn.springframework.beans.factory.support;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

/**
 * 抽象自动装配bean工厂
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            Class beanClass = beanDefinition.getBeanClass();
            bean = beanClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        //从DefaultSingletonBeanRegistry继承而来
        addSingleton(beanName, bean);
        return bean;
    }
}
