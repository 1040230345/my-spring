package cn.springframework.beans.factory.config;

/**
 * bean定义（spring源码中类名一样）
 * jackson
 * 2021年08月04日00:36:51
 */
public class BeanDefinition<T> {

    private Class<T> beanClass;

    public BeanDefinition(Class<T> beanClass){
        this.beanClass = beanClass;
    }

    public Class<T> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<T> beanClass) {
        this.beanClass = beanClass;
    }
}
