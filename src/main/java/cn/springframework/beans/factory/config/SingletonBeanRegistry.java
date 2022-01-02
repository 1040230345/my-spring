package cn.springframework.beans.factory.config;

/**
 * 单例注册接口定义和实现
 * 2021年08月04日00:43:30
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
