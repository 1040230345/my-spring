package cn.springframework;

/**
 * bean工厂
 * jackson
 * 2021年08月04日00:39:07
 */
public interface BeanFactory {

    //获取bean
    Object getBean(String name);

    Object getBean(String name,Object... arg);

}
