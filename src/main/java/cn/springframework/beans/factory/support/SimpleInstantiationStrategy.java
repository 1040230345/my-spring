package cn.springframework.beans.factory.support;

import cn.springframework.beans.BeansException;
import cn.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * jdk实例方法
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public <T> Object instantiate(BeanDefinition<T> beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException {

        Class<?> clazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(ctor.getParameterTypes());
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
