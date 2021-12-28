package cn.springframework.beans.factory.support;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 抽象自动装配bean工厂
 */
public abstract class AbstractAutowireCapableBeanFactory<T> extends AbstractBeanFactory<T>{

    private InstantiationStrategy<T> instantiationStrategy = new SimpleInstantiationStrategy<T>();

    @Override
    protected T createBean(String beanName, BeanDefinition beanDefinition,Object... arg) throws BeansException {
        T bean = null;
        try {
            bean = (T) createBeanInstance(beanDefinition,beanName,arg);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        //从DefaultSingletonBeanRegistry继承而来
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor<T> constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            //简单判断下参数个数是否一致
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = (Constructor<T>) ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy<T> instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
