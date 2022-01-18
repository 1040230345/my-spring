package cn.springframework.beans.factory;

/**
 * bean工厂
 * jackson
 * 2021年08月04日00:39:07
 */
public interface BeanFactory {

    //获取bean
    Object getBean(String name);

    //有参构造函数注入
    Object getBean(String name,Object... arg);

    //根据bean类型获取
    <T> T getBean(String name, Class<T> requiredType);

}
