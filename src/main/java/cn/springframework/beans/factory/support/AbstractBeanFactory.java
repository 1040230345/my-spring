package cn.springframework.beans.factory.support;

import cn.springframework.BeanFactory;
import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.BeanDefinition;

/**
 * 抽象bean工厂
 * jackson
 * 2021年08月04日00:40:37
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
        implements BeanFactory {

    @Override
    public Object getBean(String name){
        Object bean = getSingleton(name);
        if(bean != null){
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);

        return createBean(name,beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
