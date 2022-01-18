package cn.springframework.beans.factory.support;

import cn.springframework.beans.factory.BeanFactory;
import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.BeanDefinition;

/**
 * 抽象bean工厂
 * jackson
 * 2021年08月04日00:40:37
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
        implements BeanFactory {

    /**
     * 从beanFactory继承来的需要实现获取bean的方法
     * @param name
     * @return
     */
    @Override
    public Object getBean(String name){
       return doGetBean(name, null);
    }

    /**
     * 有参构造函数bean创建
     * @param name
     * @param arg
     * @return
     */
    @Override
    public Object getBean(String name, Object... arg) {
        return doGetBean(name,arg);
    }


    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object... arg) throws BeansException;
}
